package banking.app.services.impl;

import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import banking.app.models.Account;
import banking.app.repositories.AccountRepository;
import banking.app.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        System.out.println("Saved Account: " + createAccountDto); // Debug log
        Account account = modelMapper.map(createAccountDto, Account.class);
        Account savedAccount = accountRepository.save(account);
        System.out.println("Saved Account: " + savedAccount); // Debug log
        AccountDto responseDto = modelMapper.map(savedAccount, AccountDto.class);
        System.out.println("Response DTO: " + responseDto); // Debug log
        return responseDto;
    }
}
