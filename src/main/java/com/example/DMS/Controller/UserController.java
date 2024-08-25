package com.example.DMS.Controller;

import com.example.DMS.Dto.UserLoginDto;
import com.example.DMS.Dto.UserRegisterationDto;
import com.example.DMS.Model.User;
import com.example.DMS.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



//    @PostMapping("/register")
//    public User registerUser(@RequestBody User user){
//       return userService.register(user);
//    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegisterationDto userDTO) {
        User registeredUser = userService.register(userDTO);
        return ResponseEntity.ok(registeredUser);
    }


//    @PostMapping("/login")
//    public String loginUser(@RequestBody User user){
//        return userService.verify(user);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDto userDTO) {
//        String token = userService.verify(userDTO);
//        return ResponseEntity.ok(token);
//    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDto userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        String token = userService.verify(userDTO);
        return ResponseEntity.ok(token);
    }


}
