package banking.app.services;


import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IAccountService {

    public List<AccountDto> getAll();
    public AccountDto createAccount(CreateAccountDto createAccountDto);
    public AccountDto getAccountById(Long id);
    public AccountDto deposit(Long id, double amount);
    public AccountDto withdraw(Long id, double amount);
    public void delete(Long id);

}
