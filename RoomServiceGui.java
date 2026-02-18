/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class RoomServiceGui extends JFrame {
    JComboBox<String> breakfastComboBox;
    JComboBox<String> drinkComboBox;
    JButton orderButton;
    JLabel breakfastlabel;
    public double breakfastPrice=0;
    public double drinkPrice=0;
    
    JLabel roomCleaning;
    JRadioButton yesClean;
    JRadioButton noClean;
    ButtonGroup cleanGrb;
    public double cleaningPrice=0;
    JLabel Totallabel;
    public double totalServiceBill;
    JLabel menuLabel2;
    
    //database, auto increament for customer id
    int customerID=4;
    public int getNextId() {
    return ++customerID;
    }
    int newID;
    
    RoomServiceGui(){
      this.setTitle("   Room Services ");
      this.setSize(600,500);
      this.setLayout(new FlowLayout());
      this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      
      breakfastlabel=new JLabel(" selected breakfast and drink ");
      
      
      String[] breakfastTypes = new String[]{"Continental Breakfast","American Breakfast","Vegetarian Breakfast"};
      breakfastComboBox = new JComboBox(breakfastTypes);
      breakfastComboBox.addItemListener((e) -> {
      if (e.getStateChange() == 1) {
          String selectedBreakfast = (String)breakfastComboBox.getSelectedItem();
          if(selectedBreakfast.equals("Continental Breakfast")){
             breakfastPrice=30.0;
             
          }else if(selectedBreakfast.equals("American Breakfast")){
             breakfastPrice=40.0;
             
          }else if(selectedBreakfast.equals("Vegetarian Breakfast")){
             breakfastPrice=35.0;
             
          }else {
             breakfastPrice=0.0;
          }
          breakfastlabel.setText("Your selected breakfast:  "+(String)breakfastComboBox.getSelectedItem()+"  ,and drink:  "+(String)drinkComboBox.getSelectedItem());
      }
      });
      
      String[] drinkTypes = new String[]{"Freash Juice", "Coffee", "Tea","No Drink"};
      drinkComboBox=new JComboBox(drinkTypes);
      drinkComboBox.addItemListener((e) -> {
      if (e.getStateChange() == 1) {
          String selectedDrink = (String)drinkComboBox.getSelectedItem();
          if(selectedDrink.equals("Freash Juice")){
             drinkPrice=12.0;
             
          }else if(selectedDrink.equals("Tea")){
             drinkPrice=8.0;
             
          }else if(selectedDrink.equals("Coffee")){
             drinkPrice=10.0;  
          }else{
             drinkPrice=0.0; 
          }
          breakfastlabel.setText("Your selected breakfast:  "+(String)breakfastComboBox.getSelectedItem()+" ,and drink:  "+(String)drinkComboBox.getSelectedItem());
      }
      });
      
      roomCleaning=new JLabel("would you like to request room cleaning service? (price is 50 SAR) ");
      yesClean=new JRadioButton("yes");
      noClean=new JRadioButton("no");
      cleanGrb= new ButtonGroup();
      cleanGrb.add(noClean);
      cleanGrb.add(yesClean);
      
      yesClean.addItemListener((e) -> {
        if (e.getStateChange() == 1) {
          if(yesClean.isSelected()==true){
            cleaningPrice=50.0;

            }
        }
      });
      
     noClean.addItemListener((e) -> {
        if (e.getStateChange() == 1) {
            if(noClean.isSelected()==true){
               cleaningPrice=0.0;

          }
        }
        });
      
      
      
      Totallabel=new JLabel("Total Room services Bill: ");
      orderButton=new JButton("order room services");
      orderButton.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            totalServiceBill=drinkPrice+breakfastPrice+cleaningPrice;
            Totallabel.setText("Total Room services Bill: "+totalServiceBill);
             //database breakfast
            newID=getNextId();
            String breakfastType =(String)breakfastComboBox.getSelectedItem();
            String drinkType =(String)drinkComboBox.getSelectedItem();
            String breakTime = "07:00:00";
            double breakfastBill=drinkPrice+breakfastPrice;
            
            RoomServiceDB.insertBreakfast(newID,breakfastType, drinkType, breakTime, breakfastBill);

            //database room cleaning
            if(noClean.isSelected()==true){
              RoomServiceDB.insertHouseCleaning(newID,0,0.0);  
            }
            else if(yesClean.isSelected()==true){
              RoomServiceDB.insertHouseCleaning(newID,1,50.00);
            }
          }
      });
      
      
      
      Icon menu2=new ImageIcon(getClass().getResource("finalmenu1.jpg"));
      menuLabel2=new JLabel("breakfast menu: ");
      menuLabel2.setIcon(menu2);
      menuLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
      menuLabel2.setVerticalTextPosition(SwingConstants.TOP);
      
      add(menuLabel2);
      add(breakfastComboBox);
      add(drinkComboBox);
      add(breakfastlabel);
      add(roomCleaning);
      add(yesClean);
      add(noClean);
      add(orderButton);
      add(Totallabel);
     
      setVisible(true);
      
    }
    public double serviceAmount(){
        return totalServiceBill=drinkPrice+breakfastPrice+cleaningPrice;
    }
}

