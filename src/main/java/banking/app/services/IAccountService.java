package banking.app.services;


import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import org.springframework.stereotype.Service;


public interface IAccountService {

    public AccountDto createAccount(CreateAccountDto createAccountDto);
}
