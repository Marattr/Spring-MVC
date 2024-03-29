package com.test.hplus.restcontroller;

import com.test.hplus.beans.Login;
import com.test.hplus.beans.User;
import com.test.hplus.exceptions.LoginFailerException;
import com.test.hplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailerException{
        System.out.println(login.getUsername()+" "+login.getPassword());
        User user=userRepository.searchByName(login.getUsername());
        if(user==null){
            //return ResponseEntity.status(404).build();
            return new ResponseEntity("User not found.",HttpStatus.NOT_FOUND);
        }

        if(user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())){
            return new ResponseEntity("Welcome, "+user.getUsername(),HttpStatus.OK);
        }else{
            throw new LoginFailerException("Invalid username or password");
        }

    }
}
