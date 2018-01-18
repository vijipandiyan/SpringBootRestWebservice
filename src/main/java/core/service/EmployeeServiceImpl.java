package core.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import core.dao.EmployeeDao;
import core.model.Employee;


@Service
@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public void addEmployee(Employee e) {
	
		employeeDao.CreateEmployee(e);
	}

}
