package dk.howard.resource;

import dk.howard.domain.Id;
import dk.howard.domain.Name;
import dk.howard.domain.User;
import dk.howard.resource.dto.UserDTO;

import javax.enterprise.context.Dependent;

@Dependent
public class Mapper {

    Id mapId(String id) {
        return new Id(id);
    }

    Name mapName(String id) {
        return new Name(id);
    }

    UserDTO map(User user) {
        return new UserDTO(user.getId().toString(), user.getName().getName());
    }
    User map(UserDTO userDTO) {
        return new User(new Id(userDTO.getId()),new Name(userDTO.getName()));
    }
}
