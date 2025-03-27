package banking.app.dtos;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {
    private String accountHolderName;
    private double balance;


    @Override
    public String toString() {
        return "CreateAccountDto{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
