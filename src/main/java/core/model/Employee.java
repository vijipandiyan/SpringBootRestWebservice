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
	    private long id;
	    private String name;

	    public Employee(){}
	    
	    public Employee(long id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public long getId() {
	        return id;
	    }
	    
	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}
