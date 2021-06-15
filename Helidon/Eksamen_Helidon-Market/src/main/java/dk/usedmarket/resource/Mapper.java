package dk.usedmarket.resource;

import dk.usedmarket.domain.*;
import dk.usedmarket.resource.dto.*;
import dk.usedmarket.service.request.CreateAdvertisementRequest;
import dk.usedmarket.service.request.CreateUserRequest;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    CreateUserRequest map(CreateUserDTO createUserDTO) {
        return new CreateUserRequest(
                createUserDTO.getfName(),
                createUserDTO.getlName(),
                createUserDTO.getcName(),
                createUserDTO.getPhoneNo(),
                createUserDTO.getPhoneCode(),
                createUserDTO.getEmail(),
                createUserDTO.getCreationDate(),
                createUserDTO.getZip(),
                createUserDTO.getType()
        );
    }

    UserDTO mapUser(User user) {
        return new UserDTO(
                user.getId(),
                user.getfName(),
                user.getlName(),
                user.getcName(),
                user.getPhoneNo(),
                user.getPhoneCode(),
                user.getEmail(),
                user.getCreationDate(),
                user.getLocation(),
                user.getType()
        );
    }

    CategoryDTO map(Category category) {
        return new CategoryDTO(category.getId(), category.getDescription());
    }

    CategoryWithCountDTO mapWithCount(Category category) {
        return new CategoryWithCountDTO(category.getId(), category.getDescription(), category.getCount());
    }

    List<CategoryDTO> mapCategories(List<Category> categories) {
        return categories.stream().map(this::map).collect(Collectors.toList());
    }

    List<CategoryWithCountDTO> mapCategoriesWithCount(List<Category> categories) {
        return categories.stream().map(this::mapWithCount).collect(Collectors.toList());
    }

    CreateAdvertisementRequest map(UUID id, CreateAdvertisementDTO advertisementDTO) {
        return new CreateAdvertisementRequest(
                advertisementDTO.getType(),
                advertisementDTO.getHeadline(),
                advertisementDTO.getText(),
                advertisementDTO.getPrice(),
                id,
                advertisementDTO.getCategory(),
                advertisementDTO.getCreationDate());
    }

    AdvertisementDTO map(Advertisement advertisement) {
        return new AdvertisementDTO(
                advertisement.getId(),
                advertisement.getType(),
                advertisement.getHeadline(),
                advertisement.getText(),
                advertisement.getPrice(),
                advertisement.getUserId(),
                advertisement.getCategory(),
                advertisement.getCreationDate());
    }

    List<AdvertisementDTO> mapAdvertisements(List<Advertisement> advertisements) {
        return advertisements.stream().map(this::map).collect(Collectors.toList());
    }

    AdvertisementWithLocationDTO mapWithLocation(AdvertisementWithLocation advertisement) {
        return new AdvertisementWithLocationDTO(
                advertisement.getId(),
                advertisement.getType(),
                advertisement.getHeadline(),
                advertisement.getText(),
                advertisement.getPrice(),
                advertisement.getUserId(),
                advertisement.getCategory(),
                advertisement.getCreationDate(),
                advertisement.getLocation());
    }

    List<AdvertisementWithLocationDTO> mapAdvertisementsWithLocation(List<AdvertisementWithLocation> advertisements) {
        return advertisements.stream().map(this::mapWithLocation).collect(Collectors.toList());
    }
}
