package pharmacy.service;

import pharmacy.domain.UserProfile;
import pharmacy.repository.UserProfileRepository;
import pharmacy.repository.UserProfileRepositoryImpl;

public class UserProfileServiceImpl {

    private static UserProfileRepository userProfileRepository = new UserProfileRepositoryImpl();
    private static UserProfile userProfile;
    
    public static void initializeUserProfile(String userLogin, String userPassword) {
        userProfile = userProfileRepository.initializeUserProfile(userLogin,userPassword);
    }

    public static String getName() {
        return userProfile.getName();
    }

    public static String getFirstName() {
        return userProfile.getFirstName();
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    public String getLastName() {
        return userProfile.getLastName();
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getAddress() {
        return userProfile.getAddress();
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getEmail() {
        return userProfile.getEmail();
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPhoneNumber() {
        return userProfile.getPhoneNumber();
    }

//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public String getLogin() {
        return userProfile.getLogin();
    }

//    public void setLogin(String login) {
//        this.login = login;
//    }

    public String getPassword() {
        return userProfile.getPassword();
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

    public static String getJobTitle() {
        return userProfile.getJobTitle();
    }

//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }

    public int getSalary() {
        return userProfile.getSalary();
    }

//    public void setSalary(int salary) {
//        this.salary = salary;
//    }

    public static int getPharmacyId() {
        return userProfile.getPharmacyId();
    }

//    public void setPharmacyId(int pharmacyId) {
//        this.pharmacyId = pharmacyId;
//    }

    public static int getUserId() {
        return userProfile.getUserId();
    }

//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
    public static boolean isCorrect() {
        return userProfile.isCorrect();
    }
}