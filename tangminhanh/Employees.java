package tangminhanh;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    private List<Employee> employeeList;

    // Constructor
    public Employees() {
        employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
