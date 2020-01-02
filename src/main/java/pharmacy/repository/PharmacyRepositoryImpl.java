package pharmacy.repository;

import pharmacy.domain.PharmacyData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class PharmacyRepositoryImpl implements PharmacyRepository {

    @Override
    public PharmacyData readPharmacy(int pharmacyId) {
        final String sqlGetData = "SELECT pharmacy_id, pharmacy_name, address, email, phone_number\n" +
                "FROM public.pharmacies WHERE pharmacy_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        PharmacyData pharmacyData = new PharmacyData();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1,pharmacyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                pharmacyData.setPharmacyId(resultSet.getInt("pharmacy_id"));
                pharmacyData.setPharmacyName(resultSet.getString("pharmacy_name"));
                pharmacyData.setAddress(resultSet.getString("address"));
                pharmacyData.setEmail(resultSet.getString("email"));
                pharmacyData.setPhoneNumber(resultSet.getString("phone_number"));
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return pharmacyData;
    }

    @Override
    public void updatePharmacy(PharmacyData pharmacyData) {
        final String sqlUpdatePharmacy = "UPDATE public.pharmacies\n" +
                "    SET address=?, email=?, phone_number=?\n" +
                "WHERE pharmacy_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sqlUpdatePharmacy);

            preparedStatement.setString(1, pharmacyData.getAddress());
            preparedStatement.setString(2, pharmacyData.getEmail());
            preparedStatement.setString(3, pharmacyData.getPhoneNumber());
            preparedStatement.setInt(4, pharmacyData.getPharmacyId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }
    }

    @Override
    public List<PharmacyData> getAllPharmacies() {
        final String sqlGetAllPharmacies = "SELECT pharmacy_id, pharmacy_name, address, email, phone_number\n" +
                "    FROM pharmacies\n" +
                "ORDER BY pharmacy_id ASC;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<PharmacyData> pharmacyDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetAllPharmacies);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                PharmacyData pharmacyData = new PharmacyData();

                pharmacyData.setPharmacyId(resultSet.getInt("pharmacy_id"));
                pharmacyData.setPharmacyName(resultSet.getString("pharmacy_name"));
                pharmacyData.setAddress(resultSet.getString("address"));
                pharmacyData.setEmail(resultSet.getString("email"));
                pharmacyData.setPhoneNumber(resultSet.getString("phone_number"));

                pharmacyDataList.add(pharmacyData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return pharmacyDataList;
    }
}