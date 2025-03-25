package banking.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountDto {
    private Long id;
    private String accountHandlerName;
    private double balance;
}
