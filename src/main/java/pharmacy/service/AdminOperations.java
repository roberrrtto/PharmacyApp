package pharmacy.service;

import pharmacy.domain.*;
import pharmacy.utils.DataBaseInit;

import java.util.List;

public class AdminOperations {

    private static UserInitData userInitData;
    private DataBaseInit dataBaseInit;
    private UserDataAdminForm newUser;
    private UserDataAdminForm updateUser;
    private List<UserInfoData> userInfoDataList;
    private String[] employeeList;

    public AdminOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
        setUserInfoDataList();
        setEmployeeList();
    }

    // =================== CRUD for the User ===================
    public void createNewUser(String firstName, String lastName, String address, String email, String phoneNumber,
                              String login, String password, String jobTitle, int salary, int pharmacyId) {
        this.newUser = new UserDataAdminForm(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        getDataBaseInit().createNewUser(newUser);
    }

    public void setUserInfoForUpdate(String firstName, String lastName, String address, String email, String phoneNumber,
                              String login, String password, String jobTitle, int salary, int pharmacyId) {
        int userID = updateUser.getUserId();
        this.updateUser = new UserDataAdminForm(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        updateUser.setUserId(userID);
        getDataBaseInit().updateUser(updateUser);
    }

    public UserDataAdminForm getUserInfoForUpdate() {
        return updateUser;
    }

    public void removeUser(int index) {
        int uid = userInfoDataList.get(index).getUserId();
        getDataBaseInit().removeUser(uid);
        updateEmployeeList();
    }

    // =================== Helping methods ===================
    public void setUserInfoDataList() {
        this.userInfoDataList = getDataBaseInit().getAllUsers();
    }

    public void setEmployeeList() {
        this.employeeList = new String[getUserInfoDataList().size()];
        int i = 0;
        for (UserInfoData uid : getUserInfoDataList()) {
            employeeList[i] = uid.getName();
            i++;
        }
    }

    public void updateEmployeeList() {
        setUserInfoDataList();
        setEmployeeList();
    }

    public void setUpdateUser(int index) {
        int userId = userInfoDataList.get(index).getUserId();
        this.updateUser = getDataBaseInit().getUserDataForAdminForm(userId);
    }

    // =================== Getters/Setters ===================
    public String[] getEmployeeList() {
        return employeeList;
    }

    public static UserInitData getUserInitData() { return userInitData; }

    public DataBaseInit getDataBaseInit() { return dataBaseInit; }

    public List<UserInfoData> getUserInfoDataList() {
        return userInfoDataList;
    }

}
