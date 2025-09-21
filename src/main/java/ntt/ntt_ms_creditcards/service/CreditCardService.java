package ntt.ntt_ms_creditcards.service;

import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import reactor.core.publisher.Mono;

public interface CreditCardService {

    Mono<CreditCardResponseDto> findCreditCardById(String id);
    Mono<CreditCardResponseDto> saveCreditCard(CreditCardRequestDto request);
}
