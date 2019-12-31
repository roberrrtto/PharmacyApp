package pharmacy.service;

import pharmacy.domain.PharmacyStorageData;
import pharmacy.domain.ReceiptData;
import pharmacy.repository.PharmacyStorageRepository;
import pharmacy.repository.PharmacyStorageRepositoryImpl;
import pharmacy.repository.ReceiptRepository;
import pharmacy.repository.ReceiptRepositoryImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {

    private PharmacyStorageRepository pharmacyStorageRepository;
    private ReceiptRepository receiptRepository;
    private PharmacyStorageData medicineToBasket;
    private ReceiptData receiptData;
    private List<PharmacyStorageData> pharmacyStorageDataList;
    private List<PharmacyStorageData> basketList;
    private String[] medicinesInStorageList;
    private int pharmacyId;
    private int userId;
    private double total;
    private double totalSale;
    private String[] basket;
    private String receiptToString;

    public ReceiptServiceImpl() {
        this.pharmacyStorageRepository = new PharmacyStorageRepositoryImpl();
        this.receiptRepository = new ReceiptRepositoryImpl();
        this.pharmacyId = UserProfileServiceImpl.getPharmacyId();
        this.userId = UserProfileServiceImpl.getUserId();
        setPharmacyStorageDataList();
        setMedicinesInStorageList();
        setBasketList();
        this.basket = new String[medicinesInStorageList.length];
    }

    @Override
    public void addNewReceipt() {
        setReceiptToString();
        ReceiptData receipt = new ReceiptData(pharmacyId, userId, total, receiptToString);
        receiptRepository.createReceipt(receipt);
    }

    @Override
    public void setPharmacyStorageDataForUpdate() {
        for (PharmacyStorageData psd : getPharmacyStorageDataList()) {
            pharmacyStorageRepository.updatePharmacyStorageQuantity(psd);
        }
    }

    @Override
    public void setUpdateMedicineInStorageData(int index) {
        getPharmacyStorageDataList().get(index).setQuantity(getPharmacyStorageDataList().get(index).getQuantity() - 1);
    }

    @Override
    public void setBasketList() {
        this.basketList = new ArrayList<>();
    }

    @Override
    public void updateBasketList(int index) {
        medicineToBasket = getPharmacyStorageDataList().get(index);
        if (basketList.contains(medicineToBasket)) {
            int index1 = basketList.indexOf(medicineToBasket);
            basketList.get(index1).setQuantity(basketList.get(index1).getQuantity() + 1);
        } else {
            PharmacyStorageData newMedicineToBasket = new PharmacyStorageData();
            newMedicineToBasket.setPharmacyId(medicineToBasket.getPharmacyId());
            newMedicineToBasket.setMedicineId(medicineToBasket.getMedicineId());
            newMedicineToBasket.setMedicineName(medicineToBasket.getMedicineName());
            newMedicineToBasket.setPrice(medicineToBasket.getPrice());
            newMedicineToBasket.setQuantity(1);
            basketList.add(newMedicineToBasket);
        }
        updateTotal();
        updateBasket();
    }

    @Override
    public String[] getMedicinesInStorageList() {
        return medicinesInStorageList;
    }

    @Override
    public void setPharmacyStorageDataList() {
        this.pharmacyStorageDataList = pharmacyStorageRepository.readPharmacyStorageData(pharmacyId);
    }

    @Override
    public List<PharmacyStorageData> getPharmacyStorageDataList() {
        return pharmacyStorageDataList;
    }

    @Override
    public void setMedicinesInStorageList() {
        this.medicinesInStorageList = new String[getPharmacyStorageDataList().size()];
        int i = 0;
        for (PharmacyStorageData psd : getPharmacyStorageDataList()) {
            getMedicinesInStorageList()[i] = psd.getMedicineName() + ", price: " + psd.getPrice() + "$";
            i++;
        }
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public void updateTotal() {
        total += medicineToBasket.getPrice();
        BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP);
        setTotal(bd.doubleValue());
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public void setBasket() {
        this.basket = new String[medicinesInStorageList.length];
    }

    @Override
    public void updateBasket() {
        int i = 1;
        int y = 0;
        for (PharmacyStorageData psd : basketList) {
            String sb = i + ". " + psd.getMedicineName() + " " +
                    psd.getQuantity() + " * " + psd.getPrice() + "$\n";
            basket[y] = sb;
            i++;
            y++;
        }
    }

    @Override
    public String[] getBasket() {
        return basket;
    }

    @Override
    public void setReceiptData(int receiptId) {
        this.receiptData = receiptRepository.readReceipt(receiptId);
    }

    @Override
    public ReceiptData getReceiptData() {
        return receiptData;
    }

    @Override
    public String getReceiptToString() {
        return receiptToString;
    }

    @Override
    public void setReceiptToString() {
        receiptToString = Arrays.toString(basket).replaceAll("[\\[\\]]|null|, ","");
    }

    @Override
    public void setTotalSale(Date date1, Date date2) {
        this.totalSale = receiptRepository.getTotalSale(pharmacyId, date1, date2).getTotal();
    }

    @Override
    public double getTotalSale() {
        BigDecimal bd = new BigDecimal(totalSale).setScale(2, RoundingMode.HALF_UP);
        this.totalSale = bd.doubleValue();
        return totalSale;
    }
}