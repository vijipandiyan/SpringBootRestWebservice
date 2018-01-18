package core.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import core.model.Employee;

@Repository
@Transactional
public class EmployeeDao {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void CreateEmployee(Employee e) {
    	
    	jdbcTemplate.execute("insert into emp (id) values (77)");		
	}

}
