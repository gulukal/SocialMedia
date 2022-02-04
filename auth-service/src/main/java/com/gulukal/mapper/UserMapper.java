package com.gulukal.mapper;


import com.gulukal.dto.request.DoLoginRequestDto;
import com.gulukal.dto.request.RegisterRequestDto;
import com.gulukal.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface UserMapper {

    // Birebir aynı olan alanların eşleşmesi durumu var.
    // Eğer alanların yani değişken adlarının aynı olmadığı durumlarda set işlemi nasıl olcak?
    // @Mapping(source = "email",target = "username")
    @Mapping(source = "email",target = "username")
    @Mapping(source = "sifre",target = "password")
    User toUser(RegisterRequestDto dto);

    //parametreler ayni oldugu icin map yapmaya gerek yok
    DoLoginRequestDto toDoLoginRequestDto(User user);
}