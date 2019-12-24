package pharmacy.repository;

import pharmacy.domain.MedicineData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static pharmacy.utils.DataBaseInit.closeDataBaseResources;
import static pharmacy.utils.DataBaseInit.initializeDataBaseConnection;

public class MedicineRepositoryImpl implements MedicineRepository {
    @Override
    public void createMedicine(MedicineData medicineData) {

    }

    @Override
    public MedicineData readMedicine(int medicineId) {
        final String sqlGetData = "SELECT medicine_id, medicine_name, price, medicine_description\n" +
                "   FROM public.medicines WHERE medicine_id=?;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        MedicineData medicineData = new MedicineData();

        try {
            preparedStatement = connection.prepareStatement(sqlGetData);
            preparedStatement.setInt(1,medicineId);
            ResultSet resultSet = preparedStatement.executeQuery();

//            while (resultSet.next()) {

                medicineData.setMedicineId(resultSet.getInt("medicine_id"));
                medicineData.setMedicineName(resultSet.getString("medicine_name"));
                medicineData.setPrice(resultSet.getDouble("price"));
                medicineData.setMedicineDescription(resultSet.getString("medicine_description"));
//            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return medicineData;
    }

    @Override
    public void updateMedicine(MedicineData medicineData) {

    }

    @Override
    public void deleteMedicine(int medicineId) {

    }

    @Override
    public List<MedicineData> getAllMedicines() {
        final String sqlGetAllMedicines = "SELECT medicine_id, medicine_name, price, medicine_description\n" +
                "    FROM public.medicines;";

        Connection connection = initializeDataBaseConnection();
        PreparedStatement preparedStatement = null;

        List<MedicineData> medicineDataList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(sqlGetAllMedicines);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MedicineData medicineData = new MedicineData();

                medicineData.setMedicineId(resultSet.getInt("medicine_id"));
                medicineData.setMedicineName(resultSet.getString("medicine_name"));
                medicineData.setPrice(resultSet.getDouble("price"));
                medicineData.setMedicineDescription(resultSet.getString("medicine_description"));

                medicineDataList.add(medicineData);
            }
        } catch (SQLException e) {
            System.err.println("Error during invoke SQL query: \n" + e.getMessage());
            throw new RuntimeException("Error during invoke SQL query");
        } finally {
            closeDataBaseResources(connection, preparedStatement);
        }

        return medicineDataList;
    }

    @Override
    public List<MedicineData> getAllMedicinesByUnit(int pharmacyId) {
        return null;
    }
}