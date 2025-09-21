package ntt.ntt_ms_creditcards.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ntt.ntt_ms_creditcards.enums.CustomerType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    public String id;
    public CustomerType type;
}
