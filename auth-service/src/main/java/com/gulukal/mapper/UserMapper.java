package com.gulukal.mapper;


import com.gulukal.dto.request.RegisterRequestDto;
import com.gulukal.dto.response.DoLoginResponseDto;
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
     // Alanlar bire bir eşit olduğu için mapping kullanmadık.
     DoLoginResponseDto toDoLoginResponseDto(User user);

}
