package fr.formation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.formation.Event.Event;
import fr.formation.artist.Artist;

import java.util.Collection;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity
public class User {

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
	private String deptName;
	
	@Column(nullable = false)
	private String deptCode;
	
	
	@ OneToOne()
	private Artist artist;
	
	@ManyToMany()
	
	private Collection<Event> event;

	
	
	


	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}


	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email ) {
		this.email = email;
	}
	
	/**
	 * Gets cityName
	 * @return cityName
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * Sets cityName.
	 *
	 * @param cityName the CityName
	 */
	public void setCityName(String cityName ) {
		this.cityName = cityName;
	}
	
	/**
	 * Gets cityCode
	 * @return cityName
	 */
	public String getCityCode() {
		return cityName;
	}
	
	/**
	 * Sets cityCode.
	 *
	 * @param cityCode the CityCode
	 */
	public void setCityCode(String cityCode ) {
		this.cityCode = cityCode;
	}
	
	/**
	 * Gets deptName
	 * @return deptName
	 */
	public String getDepartementName() {
		return deptName;
	}
	
	/**
	 * Sets deptName.
	 *
	 * @param cityCode the CityCode
	 */
	public void setDepartemantName(String deptName ) {
		this.deptName = deptName;
	}
	
	/**
	 * Gets deptCode
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptName;
	}
	
	/**
	 * Sets deptCode.
	 *
	 * @param deptCode the deptCode
	 */
	public void setDeptCode(String deptCode ) {
		this.deptCode = deptCode;
	}
	
	
	
	

}
