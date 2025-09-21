package ntt.ntt_ms_creditcards.mapper;

import ntt.ntt_ms_creditcards.dto.CreditCardRequestDto;
import ntt.ntt_ms_creditcards.dto.CreditCardResponseDto;
import ntt.ntt_ms_creditcards.entity.CreditCard;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreditCardMapper {

    public CreditCard toEntity (CreditCardRequestDto request) {
        return CreditCard.builder()
                .customerId(request.getCustomerId())
                .cardNumber(request.getCardNumber())
                .cardHolderName(request.getCardHolderName())
                .cardNetwork(request.getCardNetwork())
                .cardCategory(request.getCardCategory())
                .creditLimit(request.getCreditLimit())
                .availableLimit(request.getAvailableLimit())
                .balance(request.getBalance())
                .issueDate(request.getIssueDate())
                .expirationDate(request.getExpirationDate())
                .status(request.getStatus())
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
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .build();
    }

}
