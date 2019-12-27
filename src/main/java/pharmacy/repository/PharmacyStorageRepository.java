package pharmacy.repository;

import pharmacy.domain.PharmacyStorageData;

import java.util.List;

public interface PharmacyStorageRepository {

    List<PharmacyStorageData> readPharmacyStorageData(int pharmacyId);

    void updatePharmacyStorageQuantity(PharmacyStorageData pharmacyStorageData);
}
