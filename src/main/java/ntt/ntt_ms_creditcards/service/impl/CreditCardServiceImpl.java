package ntt.ntt_ms_creditcards.service.impl;

import lombok.RequiredArgsConstructor;
import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.mapper.CreditCardMapper;
import ntt.ntt_ms_creditcards.repository.CreditCardRepository;
import ntt.ntt_ms_creditcards.service.CreditCardService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository repository;
    private final CreditCardMapper creditCardMapper;

    public Mono<CreditCardResponseDto> findCreditCardById(String id) {
        return repository.findById(id).map(creditCardMapper::toResponseDto);
    }

    public Mono<CreditCardResponseDto> saveCreditCard(CreditCardRequestDto request) {
        return repository.save(creditCardMapper.toEntity(request))
                .map(creditCardMapper::toResponseDto);
    }

}
