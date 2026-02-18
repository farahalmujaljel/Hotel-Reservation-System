/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelreservationsystem;

import java.sql.*;
public class RoomServiceDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/hotel";
    private static final String USER = "root"; 
    private static final String PASSWORD = "nn1234"; 
    
    
    
     // Insert into Breakfast table
    public static void insertBreakfast( int customerId,String breakfastType, String drinkType, String breakTime, double brekPrice) {
        String sql = "INSERT INTO Breakfast (customer_id, breakfast_type, drink_type, break_time, brek_price) VALUES (?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,customerId);
            stmt.setString(2, breakfastType);
            stmt.setString(3, drinkType);
            stmt.setString(4, breakTime);
            stmt.setDouble(5, brekPrice);

            stmt.executeUpdate();
            System.out.println("Breakfast record inserted!");
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }  
    }
    // Insert into House Cleaning table
    public static void insertHouseCleaning( int customerId ,int houseCleaningState, double houseCleaningPrice) {
        String sql = "INSERT INTO house_cleaning (customer_id, house_cleaning_state, house_cleaning_price) VALUES (?,?,?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, houseCleaningState);
            stmt.setDouble(3, houseCleaningPrice);

            stmt.executeUpdate();
            System.out.println("House cleaning record inserted!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}