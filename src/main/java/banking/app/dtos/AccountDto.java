package banking.app.dtos;

import lombok.Data;

@Data
public class AccountDto {

    private Long id;
    private String accountHandlerName;
    private double balance;
    
}
