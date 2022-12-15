public class EmployeeBook {
    private Employee[] employeesBase;
    public EmployeeBook(int employeesBaseLength) {
        this.employeesBase = new Employee[employeesBaseLength];
    }
    public void setEmployee(String name, int departmentNumber, double salary) {
        if (isBaseFull())
            return;
        Employee tempEmployee = new Employee(name, departmentNumber, salary);
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] == null) {
                employeesBase[i] = tempEmployee;
                break;
            }
        }

    }
    public void deleteEmployee(String name) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i].getName().equals(name)) {
                employeesBase[i] = null;
                return;
            }
        }
        System.out.println("Employee not found");

    }
    public void deleteEmployee(int id) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getID() == id) {
                employeesBase[i] = null;
                return;
            }
        }
        System.out.println("Employee not found");
    }
    public void deleteEmployee(String name, int id) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i].getName().equals(name) && employeesBase[i].getID() == id) {
                employeesBase[i] = null;
                return;
            }
        }
        System.out.println("Employee not found");
    }
    public void changeSalaryByName(String name, int salary) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getName().equals(name)) {
                employeesBase[i].setSalary(salary);
                return;
            }
        }
        System.out.println("Employee not found");
    }
    public void changeDepartmentByName(String name, int departmentNumber) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getName().equals(name)) {
                employeesBase[i].setDepartmentNumber(departmentNumber);
                return;
            }
        }
        System.out.println("Employee not found");
    }
    public void printEmployeesWithLessSalary(int maxPointSalary) {
        boolean zeroCheck = true;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && maxPointSalary > employeesBase[i].getSalary()) {
                System.out.printf("Id - %d: Name - %s: Salary - %.2f\n--------------------------------\n",
                        employeesBase[i].getID(), employeesBase[i].getName(), employeesBase[i].getSalary());
                zeroCheck = false;
            }
        }
        if (zeroCheck)
            System.out.println("No match found");
    }
    public void printEmployeeWithHigherSalary(int maxPointSalary) {
        boolean zeroCheck = true;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && maxPointSalary <= employeesBase[i].getSalary()) {
                System.out.printf("Id - %d:Name - %s:Salary - %.2f\n--------------------------------\n",
                        employeesBase[i].getID(), employeesBase[i].getName(), employeesBase[i].getSalary());
                zeroCheck = false;
            }
        }
        if (zeroCheck)
            System.out.println("No match found");
    }
    public void printEmployeeBase() {
        if (isBaseEmpty())
            return;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.printf("Name - %s:Id - %d:Department - %d:Salary - %.2f\n--------------------------------\n",
                        employeesBase[i].getName(), employeesBase[i].getID(),
                        employeesBase[i].getDepartmentNumber(), employeesBase[i].getSalary());
            }
        }
    }
    public void printEmployeeNamesByDepartments() {
        if (isBaseEmpty())
            return;
        boolean emptyCheck;
        for (int j = 1; j <= 5; j++) {
            emptyCheck = true;
            System.out.println("__________________________\nDepartment: " + j);
            for (int i = 0; i < employeesBase.length; i++) {
                if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == j) {
                    System.out.println(employeesBase[i].getName());
                    emptyCheck = false;
                }
            }
            if (emptyCheck)
                System.out.println("Empty");
        }
    }
    public void printEmployeeBase(int departmentNumber) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                System.out.printf("Name - %s:Id - %d:Salary - %.2f\n--------------------------------\n",
                        employeesBase[i].getName(), employeesBase[i].getID(), employeesBase[i].getSalary());
            }
        }
    }
    public void printEmployeeNames() {
        if(isBaseEmpty())
            return;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                System.out.println(employeesBase[i].getName());
            }
        }
    }
    public double sumSalary() {
        double result = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                result += employeesBase[i].getSalary();
            }
        }
        return result;
    }
    public double sumSalary(int departmentNumber) {
        double result = 0.0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                result += employeesBase[i].getSalary();
            }
        }
        return result;
    }
    public Employee findMinSalaryEmployee() {
        //Из задания я не понял, должен метод возращать сотрудника или печатать сам
        //И если сотрудника, надо ли как то избежать того что вызовут getName у null
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() < min) {
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public Employee findMinSalaryEmployee(int departmentNumber) {
        double min = Double.MAX_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() < min && departmentNumber == employeesBase[i].getDepartmentNumber()) {
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public Employee findMaxSalaryEmployee() {
        double min = Double.MIN_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() > min) {
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public Employee findMaxSalaryEmployee(int departmentNumber) {
        double min = Double.MIN_VALUE;
        Employee minSalaryEmployee = null;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getSalary() > min && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                minSalaryEmployee = employeesBase[i];
                min = minSalaryEmployee.getSalary();
            }
        }
        return minSalaryEmployee;
    }
    public double avgSalary() {
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null)
                counter++;
        }
        return sumSalary() / counter;
    }
    public double avgSalary(int departmentNumber) {
        int counter = 0;
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber)
                counter++;
        }
        return sumSalary(departmentNumber) / counter;
    }
    public void increaseSalaryByPercent(double percent) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                employeesBase[i].setSalary(employeesBase[i].getSalary() + employeesBase[i].getSalary() * percent / 100);
            }
        }
    }
    public void increaseSalaryByPercent(double percent, int departmentNumber) {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null && employeesBase[i].getDepartmentNumber() == departmentNumber) {
                employeesBase[i].setSalary(employeesBase[i].getSalary() + employeesBase[i].getSalary() * percent / 100);
            }
        }
    }
    private boolean isBaseEmpty() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] != null) {
                return false;
            }
        }
        System.out.println("Base are empty");
        return true;
    }
    private boolean isBaseFull() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] == null) {
                return false;
            }
        }
        System.out.println("Base are full");
        return true;
    }
     /*public void setEmployee() {
        for (int i = 0; i < employeesBase.length; i++) {
            if (i == employeesBase.length - 1 && employeesBase[i] != null) {
                System.out.println("No empty slots");
                return;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set name:");
        String tempName = scanner.nextLine();
        System.out.println("Set department number:");
        int tempDepartment = scanner.nextInt();
        System.out.println("Set salary:");
        int tempSalary = scanner.nextInt();
        Employee tempEmployee = new Employee(tempName, tempDepartment, tempSalary);
        for (int i = 0; i < employeesBase.length; i++) {
            if (employeesBase[i] == null) {
                employeesBase[i] = tempEmployee;
                break;
            }
        }
    }*/
}
