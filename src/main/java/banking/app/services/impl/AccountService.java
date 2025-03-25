package banking.app.services.impl;

import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import banking.app.models.Account;
import banking.app.repositories.AccountRepository;
import banking.app.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
        Account account = modelMapper.map(createAccountDto, Account.class);
        Account savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDto.class);
    }
}
