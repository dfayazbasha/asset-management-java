package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.reservations;
import db.DBConnection;

public class reservationsdao {

    private Connection conn;

    public reservationsdao() {
        conn = DBConnection.getConnection();
    }

    public void addreservation(reservations reserve) {
        String sql = "INSERT INTO reservations(asset_id, employee_id, reservation_date, start_date, end_date) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, reserve.getAsset_id());
            ps.setInt(2, reserve.getEmployee_id());
            ps.setDate(3, new java.sql.Date(reserve.getReservation_date().getTime()));
            ps.setDate(4, new java.sql.Date(reserve.getStart_date().getTime()));
            ps.setDate(5, new java.sql.Date(reserve.getEnd_date().getTime()));
//            ps.setString(6, reserve.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<reservations> getAllReservations() {
        List<reservations> reservationsList = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reservations reserv = new reservations(
                    rs.getInt("reservation_id"),
                    rs.getInt("asset_id"),
                    rs.getInt("employee_id"),
                    rs.getDate("reservation_date"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getString("status")
                );
                reservationsList.add(reserv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationsList;
    }

    public List<reservations> getReservationsByEmployeeId(int employeeId) {
        List<reservations> reservationsList = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE employee_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    reservations reserv = new reservations(
                        rs.getInt("reservation_id"),
                        rs.getInt("asset_id"),
                        rs.getInt("employee_id"),
                        rs.getDate("reservation_date"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status")
                    );
                    reservationsList.add(reserv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationsList;
    }

    public void approveReservationByEmployeeId(int employeeId) {
        String sql = "UPDATE reservations SET status = 'APPROVED' WHERE employee_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Reservation(s) approved for employee_id: " + employeeId);
            } else {
                System.out.println("No reservations found for employee_id: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
