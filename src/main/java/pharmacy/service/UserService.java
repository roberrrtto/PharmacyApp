package pharmacy.service;

import pharmacy.domain.UserData;

import java.util.List;

public interface UserService {

    void addNewUser(String firstName, String lastName, String address, String email, String phoneNumber,
                    String login, String password, String jobTitle, int salary, int pharmacyId);

    void setUserDataForUpdate(String firstName, String lastName, String address, String email, String phoneNumber,
                              String login, String password, String jobTitle, int salary, int pharmacyId);

    void removeUser(int index);

    UserData readUserData();

    void updateEmployeeList();

    String[] getEmployeeList();

    void setUserDataList();

    List<UserData> getUserDataList();

    void setUpdateUserData(int index);

    void setEmployeeList();
}
