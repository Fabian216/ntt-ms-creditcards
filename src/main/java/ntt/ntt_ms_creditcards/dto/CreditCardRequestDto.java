package ntt.ntt_ms_creditcards.dto;

import lombok.Getter;
import lombok.Setter;
import ntt.ntt_ms_creditcards.enums.CreditCardCategory;
import ntt.ntt_ms_creditcards.enums.CreditCardNetwork;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreditCardRequestDto {
    private String customerId;
    private String cardNumber;
    private String cardHolderName;            // Titular de la tarjeta
    private CreditCardNetwork cardNetwork;    // Red de la tarjeta: VISA, MASTERCARD, AMEX.
    private CreditCardCategory cardCategory;  // CLASICA, ORO, PLATINUM, SIGNATURE.
    private BigDecimal creditLimit;    // límite aprobado
    private BigDecimal availableLimit; // disponible
    private BigDecimal balance;        // deuda acumulada
    private LocalDate issueDate;       // fecha de emisión
    private LocalDate expirationDate;  // fecha de expiración
    private String status;             // ACTIVE, BLOCKED, CANCELLED
}
