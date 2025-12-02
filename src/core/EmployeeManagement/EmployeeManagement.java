package core.EmployeeManagement;

import java.util.ArrayList;
import java.util.Comparator;

class Employee{
    int id;
    String name;
    float salary;

    static int idCounter =0 ;

    Employee(String name , float salary){
        this.id = ++idCounter;
        this.name = name;
        this.salary = salary;
    }

    int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    float getSalary(){
        return this.salary;
    }

    void setName(String updatedName){
        this.name = updatedName;
    }
    void setSalary(float updatedSalary){
        this.salary = updatedSalary;
    }
}

public class EmployeeManagement {

    static ArrayList<Employee> employees = new ArrayList<>();

    static ArrayList<Employee> getAllEmployees(){
        return employees;
    }
    static ArrayList<Employee> getSortedBySalary(){
        ArrayList<Employee> sortedList = employees;
        sortedList.sort(Comparator.comparing(Employee::getSalary));
        return sortedList;
    }
    static Employee addEmployee(String name, float salary){
        Employee emp = new Employee(name, salary);
        employees.add(emp);
        System.out.println("User has been added successfully.");
        return emp;
    }
    static Employee findById(int id){
        for(Employee emp: employees){
            if(emp.id==id){
                return emp;
            }
        }
        return null;
    }
    static Boolean removeEmployee(int id){
        for(Employee emp: employees){
            if(emp.id == id){
                employees.remove(emp);
                return true;
            }
        }
        return false;
    }
    static float updateSalary(int id, float salary){
        for(Employee emp: employees){
            if(emp.id == id){
                emp.salary = salary;
                return emp.salary;
            }
        }
        return -1.0f;
    }
    public static void main(String [] args){
        Employee e = addEmployee("smit dhimar", 32421.34f);
        addEmployee("abc pqer", 32421.5342f);
        addEmployee("asdf asdf", 4564532.32f);

//        removeEmployee(2);
        float updatedSalary = updateSalary(1, 43232);
        System.out.println("The updated Salary is : "+ updatedSalary);

        ArrayList<Employee> allEmployees = getSortedBySalary();
        for(Employee emp: allEmployees){
            System.out.println("name: "+emp.name);
            System.out.println("salary: "+emp.salary);
        }

//        Employee emp = findById(2);
//        if(emp!= null){
//            System.out.println(emp.id+emp.name+emp.salary);
//        }


    }
}
