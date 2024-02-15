import java.util.Scanner;
public class EmployeeTextualUserInterface {
    private Employee employee;

    public EmployeeTextualUserInterface(){
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Display employee information");
            System.out.println("2. Update employee information");
            System.out.println("3. Exit");

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    displayEmployeeInformation();
                    break;
                case "2":
                    updateEmployeeInformation();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Exiting Employee Menu...");
                    break;
            }
        }
    }

    private int getChoice(int min, int max) {
        int choice = 0;
        boolean valid = false;
        Scanner scanner = null;
        while (!valid) {
            System.out.print("Enter choice (" + min + "-" + max + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice, please try again.");
                }
            } else {
                scanner.nextLine(); // clear input buffer
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.nextLine(); // clear input buffer
        return choice;
    }

    private void displayEmployeeInformation() {
        System.out.println("\n--- Employee Information ---");
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Address: " + employee.getAddress());
        System.out.println("Phone: " + employee.getPhone());
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Salary: " + employee.getSalary());
    }

    private void updateEmployeeInformation() {
        System.out.println("\n--- Update Employee Information ---");

        System.out.print("Enter new First Name: ");
        Scanner scanner = null;
        String firstName = scanner.nextLine();
        employee.setFirstName(firstName);

        System.out.print("Enter new Last Name: ");
        String lastName = scanner.nextLine();
        employee.setLastName(lastName);

        System.out.print("Enter new Address: ");
        String address = scanner.nextLine();
        employee.setAddress(address);

        System.out.print("Enter new Phone: ");
        String phone = scanner.nextLine();
        employee.setPhone(phone);

        System.out.print("Enter new Employee ID: ");
        String employeeId = scanner.nextLine();
        employee.setEmployeeId(employeeId);

        System.out.print("Enter new Salary: ");
        double salary = scanner.nextDouble();
        employee.setSalary(salary);

        System.out.println("Employee information updated.");
    }
    @Override
    public String toString() {
        return "UserInterface{" +
                "employee=" + employee +
                '}';
    }

}
