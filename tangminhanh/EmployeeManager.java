package tangminhanh;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {

    private static Employees employees = new Employees();

    static {
        // Hardcoding some employee data
        employees.getEmployeeList().add(new Employee(1, "John", "Doe", "john.doe@example.com", "Developer"));
        employees.getEmployeeList().add(new Employee(2, "Jane", "Smith", "jane.smith@example.com", "Manager"));
        employees.getEmployeeList().add(new Employee(3, "Robert", "Johnson", "robert.johnson@example.com", "Analyst"));
    }

    public Employees getAllEmployees() {
        return employees;
    }
}
