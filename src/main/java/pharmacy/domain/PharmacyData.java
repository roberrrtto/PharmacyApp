package pharmacy.domain;

import java.util.Objects;

public class PharmacyData {

    private int pharmacyId;
    private String pharmacyName;
    private String address;
    private String email;
    private String phoneNumber;
    private UserData unitManager;

    public PharmacyData() { }

    public PharmacyData(String address, String email, String phoneNumber) {
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserData getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(UserData unitManager) {
        this.unitManager = unitManager;
    }

    @Override
    public String toString() {
        return "PharmacyData{" +
                "pharmacyId=" + pharmacyId +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", unitManager=" + unitManager +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PharmacyData)) return false;
        PharmacyData that = (PharmacyData) o;
        return getPharmacyId() == that.getPharmacyId() &&
                Objects.equals(getPharmacyName(), that.getPharmacyName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPharmacyId());
    }
}