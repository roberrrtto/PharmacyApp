package pharmacy.admin;

import pharmacy.sqlStaff.*;

import java.util.List;

public class AdminOperations {

    private UserInitData userInitData;
    private DataBaseInit dataBaseInit;
    private CreateUserForm createUserForm;
    private List<UserInfoData> userInfoDataList;
    private String[] names;

    public AdminOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
        setUserInfoDataList();
        setNames();
    }

    public void createNewUser(String firstName, String lastName, String address, String email, String phoneNumber,
                              String login, String password, String jobTitle, int salary, int pharmacyId) {
        this.createUserForm = new CreateUserForm(firstName, lastName, address, email, phoneNumber, login,
                password, jobTitle, salary, pharmacyId);
        getDataBaseInit().createNewUser(createUserForm);
    }

    public void removeUser(int index) {
        int uid = userInfoDataList.get(index).getUserId();
        getDataBaseInit().removeUser(uid);
        updateEmployeePanel();
    }

    public void updateEmployeePanel() {
        setUserInfoDataList();
        setNames();
    }

    public void setNames() {
        this.names = new String[getUserInfoDataList().size()];
        int i = 0;
        for (UserInfoData uid : getUserInfoDataList()) {
            names[i] = uid.getName();
            i++;
        }
    }

    public String[] getNames() {
        return names;
    }

    public UserInitData getUserInitData() { return userInitData; }

    public void setUserInitData(UserInitData userInitData) { this.userInitData = userInitData; }

    public DataBaseInit getDataBaseInit() { return dataBaseInit; }

    public void setDataBaseInit(DataBaseInit dataBaseInit) { this.dataBaseInit = dataBaseInit; }

    public List<UserInfoData> getUserInfoDataList() {
        return userInfoDataList;
    }

    public void setUserInfoDataList() {
        this.userInfoDataList = getDataBaseInit().getAllUsers();
    }
}
