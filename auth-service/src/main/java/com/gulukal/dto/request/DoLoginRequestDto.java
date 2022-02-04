package com.gulukal.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter


public class DoLoginRequestDto {


    @Email(message = "Lutfen gecerli bir mail adresi giriniz")
    @NotNull(message ="Mail adresi bos birakilmaz")
    String username;
    @NotNull(message ="Password bos birakilmaz")
    @Size(min = 8,max = 32)
    String password;

}
