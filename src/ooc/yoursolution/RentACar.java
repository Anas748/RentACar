/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author user
 */
public class RentACar implements RentACarInterface {

    public RentACar(List<Car> cars1, String name1) {
    }
    //intiailzing the string that are going to be used in class
    private List<CarInterface>cars;
    private String name;
    //getter
    @Override
    public List<CarInterface> getCars(){
        return cars;
    }
    //setter 
    @Override
    public void setCars(List<CarInterface> cars){
        this.cars=cars;
    }
    //getting name
    @Override
    public String getName(){
        return name;
    }

    /**
     * Set the name of the rent-a-car.
     *
     * @param name
     */
    @Override
    public void setName(String name){
        this.name = name;
    }

   
    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent){
        int availableDay;// craeted in to store value of availableday to day 
        int count =0;// to help in boolean  
        //for each loop to go each array 
        for (CarInterface car : cars){
            //if loop to check available make
          if(car.getMake().equals(make)){
              count = 0;
              availableDay= day;
              //loop to check for time period of lenght of rent 
              for(int i=0;i<lengthOfRent;i++){
                  if(!car.isAvailable(month, day++))
                      count = 1;
                  break;
              }
          }if(count==0){
              return true;
          }
            
        }
        return false;
    }

  
    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent){
        int availableDay;// craeted in to store value availableday to day
        int count =0;// to help in boolean  
        //for each loop to go each array 
        for (CarInterface car : cars){
          if(car.getMake().equals(make)){
              count = 0;
              availableDay= day;
              //loop to check for time period of lenght of rent 
              for(int i=0;i<lengthOfRent;i++){
                  if(!car.isAvailable(month, day++))
                      count = 1;
                  break;
              }//if the  condition full fill it will return Id
          }if(count==0){
              return car.getId();
          }
            
        }
        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
       int availableDay;
       //checking availabilty 
        if(!checkAvailability(month,day,make,lengthOfRent)){
        return false;
    }   
        //if available it will store as CarNum
        int CarNum = getCarAvailable(month,day,make,lengthOfRent);
        //loop to cars for each array
        for(CarInterface car : cars){
            //checking condition for it
         if(car.getId()==CarNum && car.getMake()==make) {
          availableDay=day;
          for(int i=0;i<lengthOfRent;i++){
              car.book(month, day++);
          }
      } 
    }
        return true;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
      
    }
    }

   
   