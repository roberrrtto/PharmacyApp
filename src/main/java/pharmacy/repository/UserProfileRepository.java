package pharmacy.repository;

import pharmacy.domain.UserProfileData;

public interface UserProfileRepository {

    UserProfileData initializeUserProfile(String userLogin, String userPassword);
}
