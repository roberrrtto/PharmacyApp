package pharmacy.repository;

import pharmacy.domain.UserProfile;

public interface UserProfileRepository {

    UserProfile initializeUserProfile(String userLogin, String userPassword);
}
