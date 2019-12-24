package pharmacy.service;

import pharmacy.domain.UserData;
import pharmacy.repository.UserRepository;
import pharmacy.repository.UserRepositoryImpl;

import java.util.List;

public class AdminUsersServiceImpl implements AdminUsersService{

    private UserRepository userRepository;
    private UserData newUserData;
    private UserData updateUserData;
    private List<UserData> userDataList;
    private String[] employeeList;


    public AdminUsersServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
        setUserDataList();
        setEmployeeList();
    }

    // =================== CRUD for the User ===================
    @Override
    public void addNewUser(String firstName, String lastName, String address, String email, String phoneNumber,
                           String login, String password, String jobTitle, int salary, int pharmacyId) {
        this.newUserData = new UserData(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        userRepository.createUser(newUserData);
    }

    @Override
    public void setUserDataForUpdate(String firstName, String lastName, String address, String email, String phoneNumber,
                                     String login, String password, String jobTitle, int salary, int pharmacyId) {
        int userId = updateUserData.getUserId();
        this.updateUserData = new UserData(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        updateUserData.setUserId(userId);
        userRepository.updateUser(updateUserData);
    }

    @Override
    public void removeUser(int index) {
        int uid = userDataList.get(index).getUserId();
        userRepository.deleteUser(uid);
        updateEmployeeList();
    }

    @Override
    public UserData readUserData() {
        return updateUserData;
    }

    // =================== Helping methods ===================
    @Override
    public void updateEmployeeList() {
        setUserDataList();
        setEmployeeList();
    }

    // =================== Getters/Setters ===================
    @Override
    public String[] getEmployeeList() {
        return employeeList;
    }
    @Override
    public void setUserDataList() {
        this.userDataList = userRepository.getAllUsers();
    }
    @Override
    public List<UserData> getUserDataList() {
        return userDataList;
    }
    @Override
    public void setUpdateUserData(int index) {
        int userId = userDataList.get(index).getUserId();
        this.updateUserData = userRepository.readUser(userId);
    }
    @Override
    public void setEmployeeList() {
        this.employeeList = new String[getUserDataList().size()];
        int i = 0;
        for (UserData ud : getUserDataList()) {
            employeeList[i] = ud.getName();
            i++;
        }
    }
}
