package com.gulukal.controller;

import com.gulukal.dto.request.ProfileRequestDto;
import com.gulukal.repository.entity.Profile;
import com.gulukal.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody @Valid ProfileRequestDto dto){
        profileService.save(dto);
        return ResponseEntity.ok("Ok");
    }


    @GetMapping("/getall")
    public ResponseEntity<List<Profile>> findAll(){
        return ResponseEntity.ok(profileService.findAll());
    }


}
