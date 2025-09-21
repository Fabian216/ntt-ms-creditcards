package ntt.ntt_ms_creditcards.entity;

import lombok.*;
import ntt.ntt_ms_creditcards.enums.CreditCardCategory;
import ntt.ntt_ms_creditcards.enums.CreditCardNetwork;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "creditCards")
public class CreditCard {
    @Id
    private String id;
    // Relación con cliente
    private String customerId;

    // Datos de la tarjeta
    private String cardNumber;
    private String cardHolderName;     // Titular de la tarjeta
    private CreditCardNetwork cardNetwork;        // Red de la tarjeta: VISA, MASTERCARD, AMEX.
    private CreditCardCategory cardCategory;       // CLASICA, ORO, PLATINUM, SIGNATURE.

    // Información financiera
    private BigDecimal creditLimit;    // límite aprobado
    private BigDecimal availableLimit; // disponible
    private BigDecimal balance;        // deuda acumulada

    // Fechas y control
    private LocalDate issueDate;       // fecha de emisión
    private LocalDate expirationDate;  // fecha de expiración
    private String status;             // ACTIVE, BLOCKED, CANCELLED

    // Auditoría
    private LocalDateTime createdAt;

}
