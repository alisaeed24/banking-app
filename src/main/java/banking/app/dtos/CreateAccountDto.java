package banking.app.dtos;

import lombok.*;

@Data
@Getter
@Setter

public class CreateAccountDto {
    private String accountHolderName;
    private double balance;

    public CreateAccountDto(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public CreateAccountDto() {
    }

    @Override
    public String toString() {
        return "CreateAccountDto{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
