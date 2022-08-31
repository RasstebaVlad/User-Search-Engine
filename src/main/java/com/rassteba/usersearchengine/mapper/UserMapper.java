package com.rassteba.usersearchengine.mapper;

import com.rassteba.usersearchengine.dto.UserDto;
import com.rassteba.usersearchengine.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDate;
import java.time.Period;

@Mapper(
				componentModel = "spring",
				unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

	@Mapping(target = "firstName", source = "firstName")
	@Mapping(target = "lastName", source = "lastName")
	@Mapping(target = "age", expression = "java(calculateAge(userEntity.getBirthday()))")
	UserDto toDto(UserEntity userEntity);

	default int calculateAge(LocalDate birthDate) {
		return Period.between(birthDate, LocalDate.now()).getYears();
	}
}