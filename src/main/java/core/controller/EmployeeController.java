package core.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import core.model.Address;
import core.model.Employee;
import core.repositories.EmployeeRepository;
import core.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    EmployeeService employeeSevice;
    
    @Autowired
    EmployeeRepository empRepo;
    
    
    public void setEmpRepo(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	public void setEmployeeService(EmployeeService employeeSevice) {
    	this.employeeSevice= employeeSevice;
    }
	
    @RequestMapping("/employee")
    public Employee employee(@RequestParam(value="name", defaultValue="Sir/Madam") String name, @RequestParam(value="id", defaultValue="id") String id) {	
        return new Employee(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @PostMapping("/create")
    public Employee createEmp(@Valid @RequestBody Employee emp) {
        return empRepo.save(emp);
    }
    
    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
        Employee emp = empRepo.findOne(id);
        if(emp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(emp);
    }
    
    @GetMapping("/add/{id}")
    public ResponseEntity<Employee> getEmployeeAdrressById(@PathVariable(value = "id") Long id) {
        Employee emp = empRepo.findOne(id);
        if(emp == null) {
            return ResponseEntity.notFound().build();
        }
        
        emp.setAddress(getEmployeeAdd(id));
        return ResponseEntity.ok().body(emp);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id, 
                                           @Valid @RequestBody Employee empDetails) {
        Employee emp = empRepo.findOne(id);
        if(emp == null) {
            return ResponseEntity.notFound().build();
        }
        emp.setEmpId(empDetails.getEmpId());
        emp.setName(empDetails.getName());

        Employee updatedEmp = empRepo.save(emp);
        return ResponseEntity.ok(updatedEmp);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmp(@PathVariable(value = "id") Long id) {
        Employee emp = empRepo.findOne(id);
        if(emp == null) {
            return ResponseEntity.notFound().build();
        }

        empRepo.delete(emp);
        return ResponseEntity.ok().build();
    }
    
    
    public Address getEmployeeAdd(long empid) {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	return (restTemplate.getForObject("http://localhost:8090/address/emp/"+empid, Address.class));
    	
    }
    
}
