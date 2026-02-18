/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

/**
 *
 * @author Alaa bughararah
 */
public class Breakfast extends RoomService {

   
    private final String breakfastTime; // The time when breakfast is served.
    private final String drinkType; // The type of drink included with the breakfast.
    private final double drinkPrice; // The price of the drink.

    // Constructor for the Breakfast class.
    public Breakfast(String breakfastName, double breakfastPrice, String breakfastTime,
                     String drinkType, double drinkPrice) {
        // Call the parent and adding the drink price to the breakfast price.
        super(breakfastName, breakfastPrice + drinkPrice);

        //make sure that breakfastTime and drinkType are not null or empty.
        if (breakfastTime == null || breakfastTime.isEmpty() || drinkType == null || drinkType.isEmpty()) {
            throw new IllegalArgumentException("Breakfast time and drink type cannot be null or empty.");
        }

        //make sure  that the drink price is not negative.
        if (drinkPrice < 0) {
            throw new IllegalArgumentException("Drink price cannot be negative.");
        }

        // Initialize the class fields.
        this.breakfastTime = breakfastTime;
        this.drinkType = drinkType;
        this.drinkPrice = drinkPrice;
    }

    // Getter for breakfastTime.
    public String getBreakfastTime() {
        return breakfastTime;
    }

    // Getter for drinkType.
    public String getDrinkType() {
        return drinkType;
    }

    // Getter for drinkPrice.
    public double getDrinkPrice() {
        return drinkPrice;
    }

    // Override the displayServiceDetails method to include additional details about breakfast.
    @Override
    public void displayServiceDetails() {
        super.displayServiceDetails(); // Call the parent class's method to display general service details.
        System.out.println("Breakfast Time: " + breakfastTime); // Display the breakfast time.
        System.out.println("Drink: " + drinkType + " | Drink Price: SAR " + drinkPrice); // Display drink details.
    }
}


  
