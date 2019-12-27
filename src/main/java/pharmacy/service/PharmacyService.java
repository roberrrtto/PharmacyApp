package pharmacy.service;

import pharmacy.domain.PharmacyData;

import java.util.List;

public interface PharmacyService {

    void setPharmacyDataForUpdate(String address, String email, String phoneNumber);

    PharmacyData readPharmacyData();

    void updatePharmacyList();

    String[] getPharmacyList();

    void setPharmacyDataList();

    List<PharmacyData> getPharmacyDataList();

    void setUpdatePharmacyData(int index);

    void setPharmacyList();

    void setPharmacyUnitManager(int index);

    String getPharmacyUnitManager();


}
