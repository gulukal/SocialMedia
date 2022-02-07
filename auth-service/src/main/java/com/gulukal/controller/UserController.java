package com.gulukal.controller;


import static com.gulukal.constant.RestApiUrls.*;
import com.gulukal.dto.request.DoLoginRequestDto;
import com.gulukal.dto.request.RegisterRequestDto;
import com.gulukal.dto.response.DoLoginResponseDto;
import com.gulukal.repository.entity.User;
import com.gulukal.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(VERSION+USER)
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    // ReturnType
    // -> returnCode-> error->9XXX -> 9001-> username and password error
    // -> success-> 1XXX -> 1000, 1100
    // Burada validasyon yapılmalı.
    @PostMapping(DOLOGIN)
    @Operation(summary = "Kullanıcı girişi için kullanılacak metod")
    public ResponseEntity<DoLoginResponseDto> doLogin(@RequestBody @Valid DoLoginRequestDto dto){
        return ResponseEntity.ok(userService.findByUsernameAndPassword(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto){
        // 1. Etapta-> Auth içni kayıt olmalı
        userService.saveReturnUser(dto);
        // 2. Etapta-> User-Service e kayıt için istek atmalı, dönen cevaba göre işle devam etmeli.
        return ResponseEntity.ok().build();
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }


}
