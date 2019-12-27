package pharmacy.repository;

import pharmacy.domain.PharmacyData;

import java.util.List;

public interface PharmacyRepository {

    PharmacyData readPharmacy(int pharmacyId);

    void updatePharmacy(PharmacyData pharmacyData);

    List<PharmacyData> getAllPharmacies();
}
