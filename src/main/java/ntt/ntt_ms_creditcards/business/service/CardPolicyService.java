package ntt.ntt_ms_creditcards.business.service;

import ntt.ntt_ms_creditcards.enums.CreditCardCategory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CardPolicyService {

    public LocalDate calculateExpirationDate(CreditCardCategory category) {
        LocalDate now = LocalDate.now();
        switch (category) {
            case CLASICA:
                return now.plusYears(3);
            case ORO:
            case PLATINUM:
                return now.plusYears(4);
            case SIGNATURE:
                return now.plusYears(5);
            default:
                throw new IllegalArgumentException("Categoría de tarjeta no soportada: " + category);
        }
    }

}
