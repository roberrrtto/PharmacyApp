package pharmacy.admin;

import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.StorageData;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

public class AdminOperations {

    private UserInitData userInitData;
    private DataBaseInit dataBaseInit;

    public AdminOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
    }

    public UserInitData getUserInitData() { return userInitData; }

    public void setUserInitData(UserInitData userInitData) { this.userInitData = userInitData; }

    public DataBaseInit getDataBaseInit() { return dataBaseInit; }

    public void setDataBaseInit(DataBaseInit dataBaseInit) { this.dataBaseInit = dataBaseInit; }

}
