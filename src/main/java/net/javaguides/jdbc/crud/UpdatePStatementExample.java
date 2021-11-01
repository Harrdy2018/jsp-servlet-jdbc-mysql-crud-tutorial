package net.javaguides.jdbc.crud;

import net.javaguides.usermanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePStatementExample {
    private static final String UPDATE_USERS_SQL = "update students set name = ? where id = ?;";

    public static void main(String[] argv) throws SQLException {
        UpdatePStatementExample updateStatementExample = new UpdatePStatementExample();
        updateStatementExample.updateRecord();
    }

    public void updateRecord() throws SQLException {
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2, 1);
            System.out.println(preparedStatement);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}
