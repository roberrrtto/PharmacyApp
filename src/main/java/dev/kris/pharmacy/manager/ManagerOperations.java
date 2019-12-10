package dev.kris.pharmacy.manager;

import dev.kris.pharmacy.sqlStaff.DataBaseInit;
import dev.kris.pharmacy.sqlStaff.StorageData;
import dev.kris.pharmacy.sqlStaff.UserInfoDataManger;
import dev.kris.pharmacy.sqlStaff.UserInitData;

import java.util.List;

import static dev.kris.pharmacy.Main.pharmacyApp;

public class ManagerOperations {

    private int size;
    private String[] names;

    private UserInitData userInitData;
    private DataBaseInit dataBaseInit;
    private List<UserInfoDataManger> userInfoDataMangerList;
    private List<StorageData> storageDataList;

    public ManagerOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
        setUserInfoDataMangerList();
        setStorageDataList();
        setSize();
        setNames();
    }

    void userNameInfoDataManager() {
        for (UserInfoDataManger uidm : pharmacyApp.userInfoDataMangerList) {
            for (int i = 0; i < size; i++) {
                names[i] = uidm.getName();
            }
        }
    }

    public UserInitData getUserInitData() {
        return userInitData;
    }

    public void setUserInitData(UserInitData userInitData) {
        this.userInitData = userInitData;
    }

    public DataBaseInit getDataBaseInit() {
        return dataBaseInit;
    }

    public void setDataBaseInit(DataBaseInit dataBaseInit) {
        this.dataBaseInit = dataBaseInit;
    }

    public List<UserInfoDataManger> getUserInfoDataMangerList() {
        return userInfoDataMangerList;
    }

    public void setUserInfoDataMangerList() {
        this.userInfoDataMangerList = getDataBaseInit().getUnitUsersData(getUserInitData().getPharmacyId());
    }

    public List<StorageData> getStorageDataList() {
        return storageDataList;
    }

    public void setStorageDataList() {
        this.storageDataList = getDataBaseInit().getStorageData(getUserInitData().getPharmacyId());
    }

    public int getSize() {
        return size;
    }

    public void setSize() {
        this.size = getUserInfoDataMangerList().size();
    }

    public String[] getNames() {
        return names;
    }

    public void setNames() {
        this.names = new String[size];
        for (UserInfoDataManger uidm : getUserInfoDataMangerList()) {
            for (int i = 0; i < getSize(); i++) {
                names[i] = uidm.getName();
            }
        }
    }
}

//    List<UserInfoDataManger> userInfoDataMangerList