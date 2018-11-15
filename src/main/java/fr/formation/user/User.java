package fr.formation.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.formation.Event.Event;
import fr.formation.artist.Artist;

import java.util.Collection;

import java.util.Set;

import javax.persistence.*;

/**
 * The type User.
 */
@Entity
public class User {

	/**
	 * @param id
	 * @param username
	 * @param user_password
	 * @param user_email
	 * @param user_cityName
	 * @param user_cityCode
	 * @param user_departemantName
	 * @param user_departementCode
	 * @param user_role
	 */
	public User( String username, String user_password, String user_email, String user_cityName,
			String user_cityCode, String user_departemantName, String user_departementCode) {
		this.username = username;
		this.user_password = user_password;
		this.user_email = user_email;
		this.user_cityName = user_cityName;
		this.user_cityCode = user_cityCode;
		this.user_departemantName = user_departemantName;
		this.user_departementCode = user_departementCode;
	}


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false)
	@JsonIgnore
	private String user_password;
	
	@Column(unique = true, nullable = false)
	private String user_email;
	
	@Column(nullable = false)
	private String user_cityName;
	
	@Column(nullable = false)
	private String user_cityCode;
	
	@Column(nullable = false)
	private String user_departemantName;
	
	@Column(nullable = false)
	private String user_departementCode;
	
	
	@ OneToOne()
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	@OneToMany(mappedBy ="user" )
	private Collection<UserRole> userRoles;
	
	@ManyToMany(mappedBy ="user")
	private Set<Event> event ;
	
	

	
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
	 * Gets user_name.
	 *
	 * @return the user_name
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Sets user_name.
	 *
	 * @param username the user_name
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
		return user_password;
	}


	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String user_password) {
		this.user_password = user_password;
	}
	
	/**
	 * Gets email
	 * @return email
	 */
	public String getEmail() {
		return user_email;
	}
	
	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String user_email ) {
		this.user_email = user_email;
	}
	
	/**
	 * Gets cityName
	 * @return cityName
	 */
	public String getCityName() {
		return user_cityName;
	}
	
	/**
	 * Sets cityName.
	 *
	 * @param cityName the CityName
	 */
	public void setCityName(String user_cityName ) {
		this.user_cityName = user_cityName;
	}
	
	/**
	 * Gets cityCode
	 * @return cityName
	 */
	public String getCityCode() {
		return user_cityName;
	}
	
	/**
	 * Sets cityCode.
	 *
	 * @param cityCode the CityCode
	 */
	public void setCityCode(String user_cityCode ) {
		this.user_cityCode = user_cityCode;
	}
	
	/**
	 * Gets deptName
	 * @return deptName
	 */
	public String getDepartementName() {
		return user_departemantName;
	}
	
	/**
	 * Sets deptName.
	 *
	 * @param cityCode the CityCode
	 */
	public void setDepartemantName(String user_departeamntName ) {
		this.user_departemantName = user_departeamntName;
	}
	
	/**
	 * Gets deptCode
	 * @return deptCode
	 */
	public String getDeptCode() {
		return user_departementCode;
	}
	
	/**
	 * Sets deptCode.
	 *
	 * @param deptCode the deptCode
	 */
	public void setDeptCode(String user_departementCode ) {
		this.user_departementCode = user_departementCode;
	}
	
	

	
	
	
	

}
