/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

/**
 *
 * @author user
 */
public class Car {
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

    
}
