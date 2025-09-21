package ntt.ntt_ms_creditcards.business.service;

import ntt.ntt_ms_creditcards.enums.CreditCardCategory;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class CardNumberGeneratorService {
    private static final SecureRandom RANDOM = new SecureRandom();

    public String generate(CreditCardCategory category) {
        StringBuilder number = new StringBuilder();

        // BIN Interbank
        number.append("4547");

        // Tipo de tarjeta
        number.append(getCategoryDigit(category));

        // Numeros aleatorios
        for (int i = 0; i < 10; i++) {
            number.append(RANDOM.nextInt(10));
        }

        // Dígito de control Luhn
        int checkDigit = calculateLuhnCheckDigit(number.toString());
        number.append(checkDigit);

        return number.toString();
    }

    private int getCategoryDigit(CreditCardCategory category) {
        switch (category) {
            case CLASICA:
                return 1;
            case ORO:
                return 2;
            case PLATINUM:
                return 3;
            case SIGNATURE:
                return 4;
            default:
                throw new IllegalArgumentException("Categoría no soportada: " + category);
        }
    }

    // Algoritmo de Luhn
    private int calculateLuhnCheckDigit(String numberWithoutCheckDigit) {
        int sum = 0;
        boolean alternate = true;

        for (int i = numberWithoutCheckDigit.length() - 1; i >= 0; i--) {
            int n = Character.getNumericValue(numberWithoutCheckDigit.charAt(i));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (10 - (sum % 10)) % 10;
    }
}
