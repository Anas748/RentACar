/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author user
 */
public class BookingSystem implements BookingSystemInterface {
   
    @Override
     public RentACarInterface setupRentACar(BufferedReader in) throws IOException{
         
        return null;
         
     }
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        List<Car> cars = new ArrayList<>();

        String list, name;
        name = in.readLine();
        //apply while loop to read each line in fine
        while ((list = in.readLine()) != null) {
            //split method to get required answers
            String[] subs = list.split(":");
            Make make = Make.valueOf(subs[0]);//spliting make
            double rate = Double.parseDouble(subs[1]);//spliting rate and changing to double
            int numCar = Integer.parseInt(subs[2]);//spliting numCar and getting interger
            //adding loop to check debbuging
            for (int i = 0; i < numCar; i++) {
                Car car = new Car(i, make, rate);//requires a class in Car.java
                cars.add(car);//car obj added
            }
        }
        //To return rentAcarinterface made a obj called rentACarInterface.
        RentACarInterface rentACarInterface = new RentACar(cars, name);
        return rentACarInterface;
    }
}
