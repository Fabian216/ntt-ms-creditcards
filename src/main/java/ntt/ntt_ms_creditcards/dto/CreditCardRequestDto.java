package ntt.ntt_ms_creditcards.dto;

import lombok.Getter;
import lombok.Setter;
import ntt.ntt_ms_creditcards.enums.CreditCardCategory;
import ntt.ntt_ms_creditcards.enums.CreditCardNetwork;

import java.math.BigDecimal;

@Getter
@Setter
public class CreditCardRequestDto {
    private String customerId;
    private String cardHolderName;            // Titular de la tarjeta
    private CreditCardNetwork cardNetwork;    // Red de la tarjeta: VISA, MASTERCARD, AMEX.
    private CreditCardCategory cardCategory;  // CLASICA, ORO, PLATINUM, SIGNATURE.
    private BigDecimal creditLimit;           // límite aprobado
}
