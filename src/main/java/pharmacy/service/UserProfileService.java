package pharmacy.service;

import pharmacy.domain.UserProfileData;
import pharmacy.repository.UserProfileRepository;
import pharmacy.repository.UserProfileRepositoryImpl;

public class UserProfileService {

    private static UserProfileRepository userProfileRepository = new UserProfileRepositoryImpl();
    private static UserProfileData userProfileData;
    
    public static void initializeUserProfile(String userLogin, String userPassword) {
        userProfileData = userProfileRepository.initializeUserProfile(userLogin,userPassword);
    }

    public static String getName() {
        return userProfileData.getName();
    }

    public static String getFirstName() {
        return userProfileData.getFirstName();
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    public String getLastName() {
        return userProfileData.getLastName();
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getAddress() {
        return userProfileData.getAddress();
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getEmail() {
        return userProfileData.getEmail();
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPhoneNumber() {
        return userProfileData.getPhoneNumber();
    }

//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public String getLogin() {
        return userProfileData.getLogin();
    }

//    public void setLogin(String login) {
//        this.login = login;
//    }

    public String getPassword() {
        return userProfileData.getPassword();
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static String getJobTitle() {
        return userProfileData.getJobTitle();
    }

//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }

    public int getSalary() {
        return userProfileData.getSalary();
    }

//    public void setSalary(int salary) {
//        this.salary = salary;
//    }

    public static int getPharmacyId() {
        return userProfileData.getPharmacyId();
    }

//    public void setPharmacyId(int pharmacyId) {
//        this.pharmacyId = pharmacyId;
//    }

    public static int getUserId() {
        return userProfileData.getUserId();
    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
    public static boolean isCorrect() {
        return userProfileData.isCorrectCredentials();
    }
}