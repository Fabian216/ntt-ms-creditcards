package ntt.ntt_ms_creditcards.service;

import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditCardService {
    Flux<CreditCardResponseDto> findAllCreditCard();
    Mono<CreditCardResponseDto> findCreditCardById(String id);
    Flux<CreditCardResponseDto> findCreditCardsByCustomerId(String customerId);
    Mono<CreditCardResponseDto> saveCreditCard(CreditCardRequestDto request);
}
