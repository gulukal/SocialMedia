package com.gulukal.mapper;

import com.gulukal.dto.request.ProfileRequestDto;
import com.gulukal.repository.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProfileMapper {

    Profile toProfile(ProfileRequestDto dto);

}
