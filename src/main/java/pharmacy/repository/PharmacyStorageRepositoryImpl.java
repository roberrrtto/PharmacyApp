package pharmacy.repository;

import pharmacy.domain.PharmacyStorageData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class PharmacyStorageRepositoryImpl implements PharmacyStorageRepository {

    @Override
    public List<PharmacyStorageData> readPharmacyStorageData(int pharmacyId) {
        final String sqlGetData = "SELECT m.medicine_id, pharmacy_id, medicine_name, price, quantity FROM pharmacy_storage\n" +
                "    INNER JOIN medicines m\n" +
                "        ON pharmacy_storage.medicine_id = m.medicine_id\n" +
                "WHERE pharmacy_id=?\n" +
                "ORDER BY medicine_id ASC;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<PharmacyStorageData> pharmacyStorageDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1, pharmacyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PharmacyStorageData pharmacyStorageData = new PharmacyStorageData();

                pharmacyStorageData.setMedicineId(resultSet.getInt("medicine_id"));
                pharmacyStorageData.setPharmacyId(resultSet.getInt("pharmacy_id"));
                pharmacyStorageData.setMedicineName(resultSet.getString("medicine_name"));
                pharmacyStorageData.setPrice(resultSet.getDouble("price"));
                pharmacyStorageData.setQuantity(resultSet.getInt("quantity"));

                pharmacyStorageDataList.add(pharmacyStorageData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return pharmacyStorageDataList;
    }

    @Override
    public void updatePharmacyStorageQuantity(PharmacyStorageData pharmacyStorageData) {
        final String sqlUpdateStorageQuantity = "UPDATE pharmacy_storage\n" +
                "    SET quantity=?\n" +
                "    WHERE medicine_id=? AND pharmacy_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlUpdateStorageQuantity);
            preparedStatement.setInt(1, pharmacyStorageData.getQuantity());
            preparedStatement.setInt(2, pharmacyStorageData.getMedicineId());
            preparedStatement.setInt(3, pharmacyStorageData.getPharmacyId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
    }
}