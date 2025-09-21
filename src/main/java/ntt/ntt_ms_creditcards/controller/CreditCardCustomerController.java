package ntt.ntt_ms_creditcards.controller;

import lombok.RequiredArgsConstructor;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.service.CreditCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creditCards/customer")
public class CreditCardCustomerController {

    private final CreditCardService creditCardService;

    @GetMapping("{id}")
    public Flux<CreditCardResponseDto> getCreditCardsByCustomerId(@PathVariable String id) {
        return creditCardService.findCreditCardsByCustomerId(id);
    }

}
