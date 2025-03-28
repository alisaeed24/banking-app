package banking.app.controllers;

import banking.app.dtos.AccountDto;
import banking.app.dtos.CreateAccountDto;
import banking.app.dtos.DepositDto;
import banking.app.dtos.WithdrawDto;
import banking.app.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    //Add account Rest API
    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody CreateAccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get account by id Rest API
    @GetMapping("/getById")
    public ResponseEntity<AccountDto> getById(@RequestBody Map<String, Long> request){
        Long id = request.get("id");
        return new ResponseEntity<>(accountService.getAccountById(id), HttpStatus.OK);
    }

    //Get all accounts Rest API
    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>> getAll(){
        return new ResponseEntity<>(accountService.getAll(), HttpStatus.OK);
    }

    //Deposit account Rest API
    @PutMapping("/deposit")
    public ResponseEntity<AccountDto> deposit(@RequestBody DepositDto request){
        return new ResponseEntity<>(accountService.deposit(request.getId(), request.getAmount()), HttpStatus.OK);
    }

    //Withdraw account Rest API
    @PutMapping("/withdraw")
    public ResponseEntity<AccountDto> withdraw(@RequestBody WithdrawDto request){
        return new ResponseEntity<>(accountService.withdraw(request.getId(), request.getAmount()), HttpStatus.OK);
    }
}




