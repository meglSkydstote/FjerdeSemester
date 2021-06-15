package dk.Jonathan.resource;

import dk.Jonathan.domain.User;
import dk.Jonathan.domain.UserInfo;
import dk.Jonathan.resource.DTO.createUserDTO;

public interface Mapper {



    UserInfo map (createUserDTO userDTO);


}
