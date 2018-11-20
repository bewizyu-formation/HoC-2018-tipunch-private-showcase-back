package fr.formation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
* The type User.
*/
@Entity
@Table(name = "users")
public class User {

    /**
	 * @param username the username
	 * @param password the password
	 * @param email the email
	 * @param cityName the city name
	 * @param cityCode the city code
	 * @param deptName the department name
	 * @param deptCode the department code
	 */
	public User( String username, String password, String email, String cityName,
			String cityCode, String deptName, String deptCode) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.departmentName = deptName;
		this.departmentCode = deptCode;
	}

	public User() {}


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	@JsonIgnore
	private String password;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String cityName;
	
	@Column(nullable = false)
	private String cityCode;
	
	@Column(nullable = false)
	private String departmentName;
	
	@Column(nullable = false)
	private String departmentCode;



//	
//	@OneToMany(mappedBy ="user")
//	private Set<Event> events ;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
}
