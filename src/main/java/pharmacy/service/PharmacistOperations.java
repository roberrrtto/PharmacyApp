package pharmacy.service;

import pharmacy.utils.DataBaseInit;
import pharmacy.domain.StorageData;
import pharmacy.domain.UserInitData;

import java.util.List;

public class PharmacistOperations {

    private int size;
    private String[] storageDetails;

    private UserInitData userInitData;
    private DataBaseInit dataBaseInit;
    private List<StorageData> storageDataList;

    public PharmacistOperations(UserInitData userInitData, DataBaseInit dataBaseInit) {
        this.userInitData = userInitData;
        this.dataBaseInit = dataBaseInit;
        setStorageDataList();
        setSize();
        setStorageDetails();
    }

    public int getSize() { return size; }

    public void setSize() { this.size = size; }

    public String[] getStorageDetails() { return storageDetails; }

    public void setStorageDetails() {
        this.storageDetails = new String[getStorageDataList().size()];
        int i = 0;
        for(StorageData sd : getStorageDataList()){
            storageDetails[i] = sd.toString();
            i++;
        }
    }

    public UserInitData getUserInitData() { return userInitData; }

    public void setUserInitData(UserInitData userInitData) { this.userInitData = userInitData; }

    public DataBaseInit getDataBaseInit() { return dataBaseInit; }

    public void setDataBaseInit(DataBaseInit dataBaseInit) { this.dataBaseInit = dataBaseInit; }

    public List<StorageData> getStorageDataList() { return storageDataList; }

    public void setStorageDataList() {
        this.storageDataList = getDataBaseInit().getStorageData(getUserInitData().getPharmacyId()); }
}
