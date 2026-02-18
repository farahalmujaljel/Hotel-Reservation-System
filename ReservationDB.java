
package hotelreservationsystem;

import java.sql.*; 

public class ReservationDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root"; 
    private static final String PASSWORD = "RunEs02.06!J"; 

    
    public static void insertReservation(int customerId, String firstDay, String lastDay,
                                         String checkinTime, String checkoutTime,
                                         boolean loginState, int adminId) {
        String sql = "INSERT INTO reservation (customer_id, first_day, last_day,"
                + " checkin_time, checkout_time, login_state, admin_id)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);
            statement.setDate(2, Date.valueOf(firstDay)); // check in date, for example "2025-06-15"
            statement.setDate(3, Date.valueOf(lastDay)); // check out date, for example "2025-06-20"
            statement.setTime(4, Time.valueOf(checkinTime)); // check in time, for exapmle "15:00:00" PM
            statement.setTime(5, Time.valueOf(checkoutTime)); // check out time, for example "12:00:00" PM
            statement.setBoolean(6, loginState);
            statement.setInt(7, adminId);

            statement.executeUpdate();
            System.out.println("Reservation record inserted!");

        } catch (SQLException e) {
            System.out.println("Error inserting reservation: " + e.getMessage());
        }
    }
}
