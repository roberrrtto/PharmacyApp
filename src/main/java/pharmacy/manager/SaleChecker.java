package pharmacy.manager;

public class SaleChecker {

    private double totalSale;

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    @Override
    public String toString() {
        return "SaleChecker{" +
                "totalSale=" + totalSale +
                '}';
    }
}
