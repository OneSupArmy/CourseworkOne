public class Main {
    static Employee[] employeesBase = new Employee[10];

    public static void main(String[] args) {
    }

    public static void printEmployeesWithLessSalary(int maxPointSalary) {
        int zeroCheck = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && maxPointSalary > employeesBase[i].getSalary()) {
                System.out.printf("Id - %d\nName - %s\nSalary - %.2f\n--------------------------------\n",
                        employeesBase[i].getID(), employeesBase[i].getName(), employeesBase[i].getSalary());
                zeroCheck++;
            }
        }
        if (zeroCheck == 0)
            System.out.println("No match found");
    }
    public static void printEmployeesWithHigherSalary(int maxPointSalary) {
        int zeroCheck = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && maxPointSalary <= employeesBase[i].getSalary()) {
                System.out.printf("Id - %d\nName - %s\nSalary - %.2f\n--------------------------------\n",
                        employeesBase[i].getID(), employeesBase[i].getName(), employeesBase[i].getSalary());
                zeroCheck++;
            }
        }
        if (zeroCheck == 0)
            System.out.println("No match found");
    }
    public static void printEmployeesBase() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.printf("Name - %s\nId - %d\nDepartment - %d\nSalary - %.2f\n--------------------------------\n",
                        employeesBase[i].getName(), employeesBase[i].getID(),
                        employeesBase[i].getDepartmentNumber(), employeesBase[i].getSalary());
            }
        }
    }
    public static void printEmployeesBase(int departmentNumber) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                System.out.printf("Name - %s\nId - %d\nSalary - %.2f\n--------------------------------\n",
                        employeesBase[i].getName(), employeesBase[i].getID(), employeesBase[i].getSalary());
            }
        }
    }
    public static void printEmployeesNames() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.println(employeesBase[i].getName());
            }
        }
    }
    public static double sumSalary() {
        double result = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                result += employeesBase[i].getSalary();
            }
        }
        return result;
    }
    public static double sumSalary(int departmentNumber) {
        double result = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                result += employeesBase[i].getSalary();
            }
        }
        return result;
    }
    public static Employee findMinSalaryEmployee() {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary()<min){
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public static Employee findMinSalaryEmployee(int departmentNumber){
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary()<min && departmentNumber == employeesBase[i].getDepartmentNumber()){
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public static Employee findMaxSalaryEmployee() {
        double min = Double.MIN_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary()>min){
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public static Employee findMaxSalaryEmployee(int departmentNumber) {
        double min = Double.MIN_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary()>min && employeesBase[i].getDepartmentNumber() == departmentNumber){
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public static double avgSalary() {
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null)
                counter++;
        }
        return sumSalary() / counter;
    }
    public static double avgSalary(int departmentNumber){
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber)
                counter++;
        }
        return sumSalary(departmentNumber)/counter;
    }
    public static void increaseSalaryPercent(int percent){
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null){
                employeesBase[i].setSalary(employeesBase[i].getSalary() + employeesBase[i].getSalary() * percent /100);
            }
        }
    }
    public static void increaseSalaryPercent(int percent, int departmentNumber){
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber){
                employeesBase[i].setSalary(employeesBase[i].getSalary() + employeesBase[i].getSalary() * percent /100);
            }
        }
    }

}