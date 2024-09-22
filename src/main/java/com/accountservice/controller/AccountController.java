package com.accountservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountservice.Entity.Account;
import com.accountservice.serviceImpl.AccountServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountServiceImpl accountServiceImpl;
	
	
	@PostMapping("/createaccount")
	public ResponseEntity<Object> createAccount(@RequestBody Account account, BindingResult result){
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for(FieldError error : result.getFieldErrors()) {
				errors.add(error.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(errors);
			
		}
		Object saveAccount = accountServiceImpl.createAccount(account);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAccount);
	}
	
	
	
	@GetMapping("/getaccount/{accountId}")
	public ResponseEntity<Optional<Account>> findAccountById(@PathVariable Integer accountId)
	{
		Optional<Account> account = accountServiceImpl.getAccountById(accountId);
		
		return ResponseEntity.status(HttpStatus.OK).body(account);
		
	}
	
	@GetMapping("/accountHolderName/{accountHolderName}")
    public ResponseEntity<?> getAccountByUsername(@PathVariable String accountHolderName) {
        Account account = accountServiceImpl.getAccountByaccountHolderName(accountHolderName);
        if (account != null) {
            return ResponseEntity.ok(account);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found for username: " + accountHolderName);
        }
    }
	
	@GetMapping("/getallaccount")
	public ResponseEntity<Iterable<Account>> getAllAccount(){
		Iterable<Account> findAllAccount = accountServiceImpl.getAllAccount();
		
		return ResponseEntity.status(HttpStatus.OK).body(findAllAccount);
	}
	
	
	@PutMapping("/updateaccount/{accountId}")
	public ResponseEntity<String> updateAccount(@RequestBody Account account){
		
		
		String updateResult = accountServiceImpl.updateAccount(account);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateResult);
	
	}
	
	
	@DeleteMapping("/deleteaccount/{accountId}")
	public ResponseEntity<Object> deleteById(@PathVariable Integer accountId){
		String result =  accountServiceImpl.deleteAccountById(accountId);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@GetMapping("/fetchbalance/{accountNumber}")
	public ResponseEntity<Object> fetchBalance(@PathVariable int accountNumber) {
	    
		Account account = accountServiceImpl.getAccountBalanceByAccountNumber(accountNumber);
	    
		if (account != null) {
	        return ResponseEntity.ok().body("Current Balance for Account Number " + accountNumber + " is " + account.getCurrentBalance());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
}
