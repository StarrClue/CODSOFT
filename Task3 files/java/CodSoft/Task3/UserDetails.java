package CodSoft.Task3;

import java.sql.*;

public class UserDetails {

    private static final String url = "jdbc:mysql://localhost/atm_db";
    private static final String user = "root";
    private static final String password = "RAJs@21062001";

    public static boolean pinValidation(String accountNumber, String enterPin) {
        String query = "select pin from user where account_number = ? and pin = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            stmt.setString(2, enterPin);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean accountValidation(String accountNumber) {
        String query = "select account_number from user where account_number = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void withdraw(String accountNumber, double balance) {
        String updateQuery = "update user set balance = balance - ? where account_number = ?";
        String selectQuery = "select balance from user where account_number = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {

            updateStmt.setString(1, String.valueOf(balance));
            updateStmt.setString(2, accountNumber);
            updateStmt.executeUpdate();

            selectStmt.setString(1, accountNumber);

            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deposit(String accountNumber, double balance) {
        String updateQuery = "update user set balance = balance + ? where account_number = ?";
        String selectQuery = "select balance from user where account_number = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {

            updateStmt.setString(1, String.valueOf((balance)));
            updateStmt.setString(2, accountNumber);
            updateStmt.executeUpdate();

            selectStmt.setString(1, accountNumber);

            ResultSet rs = selectStmt.executeQuery();
            if (rs.next()) {
                rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static double getBalance(String accountNumber) {
        String query = "select balance from user where account_number = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void pinUpdate(String accountNumber, String enterPin) {
        String updateQuery = "update user set pin = ? where account_number = ?";
        String selectQuery = "select pin from user where account_number = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
             PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {

            updateStmt.setString(1, enterPin);
            updateStmt.setString(2, accountNumber);

            updateStmt.executeUpdate();

            selectStmt.setString(1, accountNumber);

            ResultSet rs = selectStmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
