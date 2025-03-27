package banking.app.controllers;

import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import banking.app.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    //Add Account Rest API
    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody CreateAccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
}
