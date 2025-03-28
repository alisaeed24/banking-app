package banking.app.services.impl;

import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import banking.app.models.Account;
import banking.app.repositories.AccountRepository;
import banking.app.services.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<AccountDto> getAll() {

        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> modelMapper.map(account, AccountDto.class))).collect(Collectors.toList());
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

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return modelMapper.map(account, AccountDto.class);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        account.setBalance(account.getBalance() + amount);
        Account savedAccount =  accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDto.class);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient Amount!!");
        }
        account.setBalance(account.getBalance() - amount);
        Account savedAccount =  accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountDto.class);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        accountRepository.delete(account);
    }
}
