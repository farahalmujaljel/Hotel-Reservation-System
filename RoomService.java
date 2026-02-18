/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;


 //Room Service Extends the Service class to inherit general service .
public class RoomService extends Service {
 

 //Room Service Extends the Service class to inherit general service .

     //Constructor for creating a RoomService object
    public RoomService(String serviceName, double price) {
        // Call the constructor
        super(serviceName, price);
    }
    
     //Overrides the displayServiceDetails() method to displays the details of the room service.
    @Override
    public void displayServiceDetails() {
        // Call the parent class's method to display basic service details.
        super.displayServiceDetails();
    }
}
