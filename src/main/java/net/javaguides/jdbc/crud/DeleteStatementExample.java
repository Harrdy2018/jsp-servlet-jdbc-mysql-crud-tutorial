package net.javaguides.jdbc.crud;

import net.javaguides.usermanagement.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatementExample {
    private static final String deleteTableSQL = "delete from students where id = 1";

    public static void main(String[] argv) throws SQLException {
        DeleteStatementExample deleteExample = new DeleteStatementExample();
        deleteExample.deleteRecord();
    }

    public void deleteRecord() throws SQLException {

        System.out.println(deleteTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
                // Step 2:Create a statement using connection object
                Statement statement = connection.createStatement();) {
            System.out.println(statement);
            // Step 3: Execute the query or update query
            statement.execute(deleteTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            JDBCUtils.printSQLException(e);
        }
    }
}
