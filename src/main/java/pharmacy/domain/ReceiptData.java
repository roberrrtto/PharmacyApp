package pharmacy.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class ReceiptData {

    private int receiptId;
    private int pharmacyId;
    private int userId;
    private double total;
    private Date date;
    private Time time;
    private String basket;

    public ReceiptData() { }

    public ReceiptData(int pharmacyId, int userId, double total, String basket) {
        this.pharmacyId = pharmacyId;
        this.userId = userId;
        this.total = total;
        this.basket = basket;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getBasket() {
        return basket;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return  "receiptId: " + receiptId +
                "\npharmacyId: " + pharmacyId +
                "\nuserId: " + userId +
                "\ntotal: " + total + "$" +
                "\ndate: " + date +
                "\ntime: " + time +
                "\nbasket: \n" + basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReceiptData)) return false;
        ReceiptData that = (ReceiptData) o;
        return getReceiptId() == that.getReceiptId() &&
                getPharmacyId() == that.getPharmacyId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiptId(), getPharmacyId());
    }
}