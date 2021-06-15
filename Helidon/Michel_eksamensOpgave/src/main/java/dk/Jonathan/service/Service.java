package dk.Jonathan.service;


import dk.Jonathan.domain.Advertisement;
import dk.Jonathan.domain.User;
import dk.Jonathan.domain.UserInfo;

import java.util.Collection;

public interface Service {
    Collection<Advertisement> getAdvertisements();
    //Question createQuestion(Question question);
    //Question getQuestion(Id id);
    void createUser(UserInfo userInfo, String zipcode);
}
