package pharmacy.repository;

import pharmacy.domain.ReceiptData;

import java.sql.Date;
import java.util.List;

public interface ReceiptRepository {

    void createReceipt(ReceiptData receiptData);

    ReceiptData readReceipt(int receiptId);

    List<ReceiptData> getAllReceiptsByUnitAndDate(int pharmacyId, Date date1, Date date2);
}
