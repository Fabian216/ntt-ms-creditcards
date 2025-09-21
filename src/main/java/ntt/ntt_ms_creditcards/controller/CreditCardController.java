package ntt.ntt_ms_creditcards.controller;

import lombok.RequiredArgsConstructor;
import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.service.CreditCardService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creditCards")
public class CreditCardController {
    private final CreditCardService creditCardService;

    @GetMapping("{id}")
    public Mono<CreditCardResponseDto> getCreditCardById(@PathVariable String id) {
        return creditCardService.findCreditCardById(id);
    }

    @PostMapping
    public Mono<CreditCardResponseDto> createCreditCard(@RequestBody CreditCardRequestDto request) {
        return creditCardService.saveCreditCard(request);
    }

}
