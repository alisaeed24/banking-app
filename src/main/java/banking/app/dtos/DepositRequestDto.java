package banking.app.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositRequestDto {
    private Long id;
    private double amount;
}
