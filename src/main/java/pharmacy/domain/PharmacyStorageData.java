package pharmacy.domain;

import java.util.Objects;

public class PharmacyStorageData extends MedicineData {

    private int pharmacyId;
    private int quantity;
    private int medicineId;

    public PharmacyStorageData() { }

    @Override
    public int getMedicineId() {
        this.medicineId = super.getMedicineId();
        return this.medicineId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PharmacyStorageData{" +
                "pharmacyId=" + pharmacyId +
                ", quantity=" + quantity +
                ", medicineId=" + medicineId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PharmacyStorageData)) return false;
        if (!super.equals(o)) return false;
        PharmacyStorageData that = (PharmacyStorageData) o;
        return getPharmacyId() == that.getPharmacyId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPharmacyId());
    }
}