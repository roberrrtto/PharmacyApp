package pharmacy.domain;

import java.util.Objects;

public class MedicineData {

    private int medicineId;
    private String medicineName;
    private double price;
    private String medicineDescription;

    public MedicineData() { }

    public MedicineData(String medicineName, double price, String medicineDescription) {
        this.medicineName = medicineName;
        this.price = price;
        this.medicineDescription = medicineDescription;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    @Override
    public String toString() {
        return "medicineName='" + medicineName + '\'' +
                ", price=" + price +
                ", medicineDescription='" + medicineDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicineData)) return false;
        MedicineData medicineData = (MedicineData) o;
        return getMedicineId() == medicineData.getMedicineId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedicineId());
    }
}
