/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author user
 */
public class Car implements CarInterface {
    private double rate;
    private int id;
    private Make make;
    Map<Month, boolean[]> calender;
    public Car(Make make,int id , double rate){
        this.id = id;
        this.rate = rate;
        this.make = make;
        createAvailability();
    }

    @Override
    public Map<Month, boolean[]> createAvailability() {
        
         calender = new HashMap<>();
         calender.put(Month.JANUARY, new boolean[31]);
        calender.put(Month.FEBRUARY, new boolean[28]);
        calender.put(Month.MARCH, new boolean[31]);
        calender.put(Month.APRIL, new boolean[30]);
        calender.put(Month.MAY, new boolean[31]);
        calender.put(Month.JUNE, new boolean[30]);
        calender.put(Month.JULY, new boolean[31]);
        calender.put(Month.AUGUST, new boolean[31]);
        calender.put(Month.SEPTEMBER, new boolean[30]);
        calender.put(Month.OCTOBER, new boolean[31]);
        calender.put(Month.NOVEMBER, new boolean[30]);
        calender.put(Month.DECEMBER, new boolean[31]);
        
        return calender;
    }

    @Override
    public Make getMake() {
        return make;
        
    }

    @Override
    public void setMake(Make make) {
       this.make = make;
       
    }

    @Override
    public double getRate() {
        return rate;
      
    }

    @Override
    public void setRate(double rate) {
       this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {
        return calender;
       
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
       this.calender  = calender;
       this.calender  = availability;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        boolean[] availability = calender.get(month);
        if (availability[day-1] != false) {
            availability[day-1] = true;
        }
        return availability[day-1];
        
    }

    @Override
    public boolean book(Month month, int day) {
            if (calender.get(month)[day-1]) {
            calender.get(month)[day-1] = false;
            return true;
        }

        return false;
    }
    
    
    
}
