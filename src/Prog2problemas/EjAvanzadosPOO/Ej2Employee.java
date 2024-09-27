package Prog2problemas.EjAvanzadosPOO;

class Employee {
    private int id, salary;
    private String firstName, lastName;

    public Employee(int id, int salary, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary*12;
    }

    public int raiseSalary(int percent) {
        return salary*percent;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Employee(1,3000,"Jose","Thorlet");
        System.out.println(employee+"\n"+"Sueldo anual: "+employee.getAnnualSalary()
                +"\n"+"Sueldo mensual con bonos porcentules: "+employee.raiseSalary(2));
    }
}
