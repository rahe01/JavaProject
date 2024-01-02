package Car_Rental_System;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

class Car{
    private int carId;
    private String brand;
    private String model;
    private double basePrisePerDay;
    private boolean isAvailavle;

    public Car(int carId, String brand, String model, double basePrisePerDay, boolean isAvailavle){
        this.carId =carId;
        this.brand = brand;
        this.model = model;
        this.basePrisePerDay =basePrisePerDay;
        this.isAvailavle = true;
    }

    public int getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailavle() {
        return isAvailavle;
    }

    public double calculatePrize(int rentalDay){
        return  basePrisePerDay*rentalDay;
    }

    public void rent(){
        isAvailavle =false;
    }
    public void returnCar(){
        isAvailavle = true;
    }
}

class Customer{
    private int customerId;
    private String name;
    private int phone;

    public  Customer(int customerId, String name, int phone){
        this.name = name;
        this.customerId = customerId;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }
}

class Rental{
    private Car  car;
    private Customer customer;

    private int days;

    public  Rental(Car car, Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}

class CarRentalSystem{
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;


    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void rentCar(Car car , Customer customer, int days){
        if (car.isAvailavle()){
            car.rent();
            rentals.add(new Rental(car,customer,days));

        }
        else {
            System.out.println("Car is not avilavle");
        }

    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);

        } else {
            System.out.println("Car was not rented.");
        }
    }

}









