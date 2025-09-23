package ntt.ntt_ms_creditcards.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.mapper.CreditCardMapper;
import ntt.ntt_ms_creditcards.repository.CreditCardRepository;
import ntt.ntt_ms_creditcards.service.CreditCardService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;
    private final CreditCardMapper creditCardMapper;

    public Flux<CreditCardResponseDto> findAllCreditCard() {
        log.info("Iniciando busqueda de tarjetas de credito");
        return repository.findAll()
                .map(creditCardMapper::toResponseDto)
                .doOnComplete(() -> log.info("Tarjetas de credito encontrados exitosamente"))
                .doOnError(e -> log.error("Error al buscar tarjetas de credito"));
    }

    public Mono<CreditCardResponseDto> findCreditCardById(String id) {
        log.info("Iniciando busqueda de tarjeta de credito con id: {}", id);
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("no encontrado")))
                .map(creditCardMapper::toResponseDto)
                .doOnSuccess((creditCard) -> log.info("Tarjeta de credito con id: {} encontrado con exito.", creditCard.getId()))
                .doOnError(e -> log.error("Fallo al obtener tarjeta de credito con id: {} , error: {}", id, e.getMessage()));
    }

    public Flux<CreditCardResponseDto> findCreditCardsByCustomerId(String id) {
        return repository.findByCustomerId(id)
                .map(creditCardMapper::toResponseDto);
    }

    public Mono<CreditCardResponseDto> saveCreditCard(CreditCardRequestDto request) {
        return repository.save(creditCardMapper.toEntity(request))
                .map(creditCardMapper::toResponseDto);
    }

}
