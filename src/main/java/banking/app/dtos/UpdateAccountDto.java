package banking.app.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
