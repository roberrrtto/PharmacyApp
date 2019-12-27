package pharmacy.service;

import pharmacy.domain.PharmacyData;
import pharmacy.domain.UserData;
import pharmacy.repository.PharmacyRepository;
import pharmacy.repository.PharmacyRepositoryImpl;
import pharmacy.repository.UserRepository;
import pharmacy.repository.UserRepositoryImpl;

import java.util.List;

public class PharmacyServiceImpl  implements PharmacyService {
    private PharmacyRepository pharmacyRepository;
    private UserRepository userRepository;
    private PharmacyData pharmacyData;
    private List<PharmacyData> pharmacyDataList;
    private String[] pharmacyList;
    private String pharmacyUnitManager;

    public PharmacyServiceImpl() {
        this.pharmacyRepository = new PharmacyRepositoryImpl();
        this.userRepository = new UserRepositoryImpl();
        setPharmacyDataList();
        setPharmacyList();
    }

    @Override
    public void setPharmacyDataForUpdate(String address, String email, String phoneNumber) {
        int pId = pharmacyData.getPharmacyId();
        this.pharmacyData = new PharmacyData(address, email, phoneNumber);
        pharmacyData.setPharmacyId(pId);
        pharmacyRepository.updatePharmacy(pharmacyData);
    }

    @Override
    public PharmacyData readPharmacyData() {
        return pharmacyData;
    }

    @Override
    public void updatePharmacyList() {
        setPharmacyDataList();
        setPharmacyList();
    }

    @Override
    public String[] getPharmacyList() {
        return pharmacyList;
    }

    @Override
    public void setPharmacyDataList() {
        this.pharmacyDataList = pharmacyRepository.getAllPharmacies();
    }

    @Override
    public List<PharmacyData> getPharmacyDataList() {
        return pharmacyDataList;
    }

    @Override
    public void setUpdatePharmacyData(int index) {
        int pId = pharmacyDataList.get(index).getPharmacyId();
        this.pharmacyData = pharmacyRepository.readPharmacy(pId);
        setPharmacyUnitManager(index);
    }

    @Override
    public void setPharmacyList() {
        this.pharmacyList = new String[getPharmacyDataList().size()];
        int i = 0;
        for (PharmacyData pd : getPharmacyDataList()) {
            pharmacyList[i] = "PhID " + pd.getPharmacyId() + " " + pd.getPharmacyName();
            i++;
        }
    }

    //////////////////// New Impl /////////////////////
    @Override
    public void setPharmacyUnitManager(int index) {
        int pId = pharmacyDataList.get(index).getPharmacyId();
        for (UserData ud : userRepository.getAllUsersByUnit(pId)) {
            if (ud.getJobTitle().equals("Unit Manager")) {
                this.pharmacyUnitManager = ud.getFirstName() + " " + ud.getLastName();
                break;
            }
        }
    }

    @Override
    public String getPharmacyUnitManager() {
        return pharmacyUnitManager;
    }
}