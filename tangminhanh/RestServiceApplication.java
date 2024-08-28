package tangminhanh;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// Import the defined classes
import tangminhanh.Employees;
import tangminhanh.EmployeeManager;
import tangminhanh.Employee;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;

    // GET method to retrieve the list of all employees
    @GetMapping(
        path = "/",
        produces = "application/json"
    )
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }

    // POST method to add a new employee
    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        // Create a new ID for the employee
        Integer id = EmployeeManager.getAllEmployees().getEmployeeList().size() + 1;
        employee.setEmployeeId(id);  // Ensure the setter method matches the private variable name

        // Add the employee to the list
        EmployeeManager.addEmployee(employee);

        // Build the URI for the newly created employee
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getEmployeeId()) // Use getEmployeeId() to match setter
                .toUri();

        // Return the ResponseEntity with created status and location header
        return ResponseEntity.created(location).build();
    }
}
