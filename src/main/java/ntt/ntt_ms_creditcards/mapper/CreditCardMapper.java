package ntt.ntt_ms_creditcards.mapper;

import lombok.RequiredArgsConstructor;
import ntt.ntt_ms_creditcards.business.service.CardNumberGeneratorService;
import ntt.ntt_ms_creditcards.business.service.CardPolicyService;
import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.entity.CreditCard;
import ntt.ntt_ms_creditcards.enums.CreditCardStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class CreditCardMapper {

    private final CardPolicyService cardPolicyService;
    private final CardNumberGeneratorService cardNumberGeneratorService;

    public CreditCard toEntity (CreditCardRequestDto request) {
        return CreditCard.builder()
                .customerId(request.getCustomerId())
                .cardNumber(cardNumberGeneratorService.generate(request.getCardCategory()))
                .cardHolderName(request.getCardHolderName())
                .cardNetwork(request.getCardNetwork())
                .cardCategory(request.getCardCategory())
                .creditLimit(request.getCreditLimit())
                .availableLimit(request.getCreditLimit())
                .balance(BigDecimal.ZERO)
                .issueDate(LocalDate.now())
                .expirationDate(cardPolicyService.calculateExpirationDate(request.getCardCategory()))
                .creditCardStatus(CreditCardStatus.ACTIVE)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public CreditCardResponseDto toResponseDto (CreditCard entity) {
        return CreditCardResponseDto.builder()
                .id(entity.getId())
                .customerId(entity.getCustomerId())
                .cardNumber(entity.getCardNumber())
                .cardHolderName(entity.getCardHolderName())
                .cardNetwork(entity.getCardNetwork())
                .cardCategory(entity.getCardCategory())
                .creditLimit(entity.getCreditLimit())
                .availableLimit(entity.getAvailableLimit())
                .balance(entity.getBalance())
                .issueDate(entity.getIssueDate())
                .expirationDate(entity.getExpirationDate())
                .creditCardStatus(entity.getCreditCardStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
