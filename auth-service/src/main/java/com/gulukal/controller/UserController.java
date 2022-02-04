package com.gulukal.controller;

import com.gulukal.dto.request.DoLoginRequestDto;
import com.gulukal.dto.request.RegisterRequestDto;
import com.gulukal.repository.entity.User;
import com.gulukal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    //@Autowired
    final  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ReturnType
    // -> returnCode-> error->9XXX -> 9001-> username and password error
    // -> success-> 1XXX -> 1000, 1100
    // Burada validasyon yapılmalı.
    @PostMapping("/dologin")
    @Operation(summary = "Kullanıcı girişi için kullanılacak metod")
    public ResponseEntity<DoLoginRequestDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        return ResponseEntity.ok(userService.findByUsernameAndPassword(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto){
        // 1. Etapta-> Auth içni kayıt olmalı
        //mapper sayesinde bu sekilde dto verebildik
        userService.saveReturnUser(dto);
        // 2. Etapta-> User-Service e kayıt için istek atmalı, dönen cevaba göre işle devam etmeli.
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }


}
