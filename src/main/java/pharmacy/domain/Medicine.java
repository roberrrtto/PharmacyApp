package pharmacy.domain;

import java.util.Objects;

public class Medicine {

    private int medicineId;
    private String medicineName;
    private double price;
    private String medicineDescription;

    public Medicine() { }

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
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return getMedicineId() == medicine.getMedicineId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMedicineId());
    }
}
