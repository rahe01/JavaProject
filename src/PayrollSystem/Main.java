package PayrollSystem;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

  /*  public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
   */


    public abstract double calculateSalary();
    @Override

    public String toString(){
        return "Employe[Name:"+name+", Id: "+id+", Salary"+calculateSalary()+"]";
    }

}

class FulltIMEemploye extends Employee{

    private double monthlySalary;

    public FulltIMEemploye(String name, int id, double monthlySalary){
        super(name,id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary(){
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{

    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmployee( String name, int id, int hoursWork, double hourlyRate){
        super(name,id);
        this.hoursWork = hoursWork;
        this.hourlyRate = hourlyRate;

    }

    @Override

    public double calculateSalary(){
        return hoursWork*hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeArrayList;

    public PayrollSystem(){
        employeeArrayList = new ArrayList<>();
    }
    public void addEmploye(Employee employee){
        employeeArrayList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToremove = null;
        for (Employee employee: employeeArrayList){
            if (employee.getId() == id){
                employeeToremove = employee;
                break;
            }
        }
        if (employeeToremove != null){
            employeeArrayList.remove(employeeToremove);
        }

    }

    public void displayEmployee(){
        for (Employee employee : employeeArrayList){
            System.out.println(employee);
        }
    }
}


public class Main {

    
    public static  void main(String... args) {
     PayrollSystem pay = new PayrollSystem();

     FulltIMEemploye emp1 = new FulltIMEemploye("Bikash",1,70000.0);
     PartTimeEmployee emp2 = new PartTimeEmployee("Rocket",2,5,1000.0);

     pay.addEmploye(emp1);
     pay.addEmploye(emp2);

        System.out.println("Initial employee");
        pay.displayEmployee();

        System.out.println("Remove employee");
        pay.removeEmployee(2);

        pay.displayEmployee();

    }
}