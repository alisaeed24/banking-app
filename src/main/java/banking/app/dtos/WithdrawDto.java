package banking.app.dtos;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WithdrawDto {
    private Long id;
    private double amount;
}
