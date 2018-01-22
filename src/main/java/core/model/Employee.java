package core.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@JsonIgnoreProperties
		@Column(name = "empid")
	    private long empId;

		private String name;
		
		private String department;
		
		private String company;
		
		private int salary;
		@JsonIgnoreProperties
		private Address address;

	    public Employee(){}
	    
	    public Employee(long empId, String name) {
	        this.empId = empId;
	        this.name = name;
	    }


	    public long getEmpId() {
			return empId;
		}

		public void setEmpId(long empId) {
			this.empId = empId;
		}
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}
}
