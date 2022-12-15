public class Employee {
    private String name;
    private int departmentNumber;
    private double salary;
    private int id;
    static int idCounter = 1;
    public Employee(String name, int departmentNumber, double salary) {
        this.name = name;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        id = idCounter;
        idCounter++;

    }
    public String getName() {
        return this.name;
    }
    public double getSalary() {
        return this.salary;
    }
    public int getDepartmentNumber() {
        return this.departmentNumber;
    }
    public int getID() {
        return this.id;
    }
    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setName(String name){ this.name = name;}
    public void setID(int id){this.id = id;}
}
