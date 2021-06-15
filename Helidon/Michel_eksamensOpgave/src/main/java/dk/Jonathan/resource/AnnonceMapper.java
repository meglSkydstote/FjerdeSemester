package dk.Jonathan.resource;

import dk.Jonathan.domain.Name;

import dk.Jonathan.domain.User;
import dk.Jonathan.domain.UserInfo;

import dk.Jonathan.resource.DTO.createUserDTO;

import javax.enterprise.context.Dependent;

@Dependent
public class AnnonceMapper implements Mapper {


    @Override
    public UserInfo map(createUserDTO userDTO) {
        return new UserInfo(
                new Name(userDTO.getFirstName(), userDTO.getLastName()),
                userDTO.getPhone_Number(),
                userDTO.getPhone_Code(),
                userDTO.getEmail(),
                userDTO.getType(),
                userDTO.getCompanyName());
    }




}
