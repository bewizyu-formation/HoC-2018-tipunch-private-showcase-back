/**
 * 
 */
package fr.formation.department;

import java.util.Set;

import javax.persistence.*;

import fr.formation.artist.Artist;

/**
 * @author adminHOC
 *
 */
@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String dept_name;
	
	@Column(nullable = false)
	private int dept_code;
	
	/**
	 * Department constructor.
	 * @param id
	 * @param dept_name
	 * @param dept_code
	 */
	public Department(Long id, String dept_name, int dept_code) {
		this.id = id;
		this.dept_name = dept_name;
		this.dept_code = dept_code;
	}
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "Art_Dept",
//			joinColumns = @JoinColumn(name = "deptId"),
//			inverseJoinColumns = @JoinColumn(name = "artistId")
//	)
//	private Set<Artist> artists;
	
	/**
	 * gets ID.
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * sets ID.
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * gets department name.
	 * @return the dept_name
	 */
	public String getDept_name() {
		return dept_name;
	}

	/**
	 * sets department name.
	 * @param dept_name the dept_name to set
	 */
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	/**
	 * gets department code.
	 * @return the dept_code
	 */
	public int getDept_code() {
		return dept_code;
	}

	/**
	 * sets department code.
	 * @param dept_code the dept_code to set
	 */
	public void setDept_code(int dept_code) {
		this.dept_code = dept_code;
	}
}
