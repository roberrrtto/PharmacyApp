package pharmacy.repository;

import pharmacy.domain.ReceiptData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class ReceiptRepositoryImpl implements ReceiptRepository {

    @Override
    public void createReceipt(ReceiptData receiptData) {

        final String sqlCreateReceipt = "INSERT INTO public.receipts(\n" +
                "    pharmacy_id, user_id, total, basket)\n" +
                "    VALUES (?, ?, ?, ?);";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlCreateReceipt);

            preparedStatement.setInt(1, receiptData.getPharmacyId());
            preparedStatement.setInt(2, receiptData.getUserId());
            preparedStatement.setDouble(3, receiptData.getTotal());
            preparedStatement.setString(4, receiptData.getBasket());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
    }

    @Override
    public ReceiptData readReceipt(int receiptId) {

        final String sqlReadReceipt = "SELECT receipt_id, pharmacy_id, user_id, total, date, time, basket\n" +
                "    FROM public.receipts\n" +
                "WHERE receipt_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        ReceiptData receiptData = new ReceiptData();

        try {
            preparedStatement = connection.prepareStatement(sqlReadReceipt);
            preparedStatement.setInt(1, receiptId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                receiptData.setReceiptId(resultSet.getInt("receipt_id"));
                receiptData.setPharmacyId(resultSet.getInt("pharmacy_id"));
                receiptData.setUserId(resultSet.getInt("user_id"));
                receiptData.setTotal(resultSet.getDouble("total"));
                receiptData.setDate(resultSet.getDate("date"));
                receiptData.setTime(resultSet.getTime("time"));
                receiptData.setBasket(resultSet.getString("basket"));
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
        return receiptData;
    }

    @Override
    public List<ReceiptData> getAllReceiptsByUnitAndDate(int pharmacyId, Date date1, Date date2) {

        final String sqlReadReceipts = "SELECT receipt_id, pharmacy_id, user_id, total, date, time, basket\n" +
                "    FROM public.receipts\n" +
                "WHERE pharmacy_id=? AND date BETWEEN ? AND ?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<ReceiptData> receiptDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlReadReceipts);
            preparedStatement.setInt(1, pharmacyId);
            preparedStatement.setDate(2, date1);
            preparedStatement.setDate(3, date2);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ReceiptData receiptData = new ReceiptData();

                receiptData.setReceiptId(resultSet.getInt("receipt_id"));
                receiptData.setPharmacyId(resultSet.getInt("pharmacy_id"));
                receiptData.setUserId(resultSet.getInt("user_id"));
                receiptData.setTotal(resultSet.getDouble("total"));
                receiptData.setDate(resultSet.getDate("date"));
                receiptData.setTime(resultSet.getTime("time"));
                receiptData.setBasket(resultSet.getString("basket"));

                receiptDataList.add(receiptData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
        return receiptDataList;
    }

    @Override
    public ReceiptData getTotalSale(int pharmacyId, Date date1, Date date2) {

        final String sqlGetTotal = "SELECT SUM(total) AS total\n" +
                "    FROM public.receipts\n" +
                "WHERE pharmacy_id=? AND date BETWEEN ? AND ?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        ReceiptData receiptData = new ReceiptData();

        try {
            preparedStatement = connection.prepareStatement(sqlGetTotal);
            preparedStatement.setInt(1, pharmacyId);
            preparedStatement.setDate(2, date1);
            preparedStatement.setDate(3, date2);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                receiptData.setTotal(resultSet.getDouble("total"));
            }

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
        return receiptData;
    }
}