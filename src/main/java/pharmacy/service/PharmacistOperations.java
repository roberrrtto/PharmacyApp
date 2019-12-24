package pharmacy.service;

import pharmacy.domain.UserProfile;
import pharmacy.utils.DataBaseInit;
import pharmacy.domain.StorageData;

import java.util.List;

public class PharmacistOperations {

    private int size;
    private String[] storageDetails;

    private UserProfile userProfile;
    private DataBaseInit dataBaseInit;
    private List<StorageData> storageDataList;

    public PharmacistOperations(UserProfile userProfile, DataBaseInit dataBaseInit) {
        this.userProfile = userProfile;
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

    public UserProfile getUserProfile() { return userProfile; }

    public void setUserProfile(UserProfile userProfile) { this.userProfile = userProfile; }

    public DataBaseInit getDataBaseInit() { return dataBaseInit; }

    public void setDataBaseInit(DataBaseInit dataBaseInit) { this.dataBaseInit = dataBaseInit; }

    public List<StorageData> getStorageDataList() { return storageDataList; }

    public void setStorageDataList() {
        this.storageDataList = getDataBaseInit().getStorageData(getUserProfile().getPharmacyId()); }
}
