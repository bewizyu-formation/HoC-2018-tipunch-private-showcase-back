package fr.formation.user;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;



public class UserInfoDTO implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5639803855314477341L;



    private Long artistId;
	@NotNull
	private String username;
	
	private String artist_name;
	
	private String departmentCode;
	
	public UserInfoDTO( Long artistId, @NotNull String username, String artist_name, @NotNull String departmentCode) {
		super();
		this.artistId = artistId;
		this.username = username;
		this.artist_name = artist_name;
		this.departmentCode = departmentCode;
	}

	public Long getArtistId() {

		return artistId;
	}

	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	
	
	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public String getuserName() {
		return username;
	}

	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUserName(String username) {
		this.username = username;
	}
	
	/**
	 * Gets artistName.
	 *
	 * @return artistName
	 */
	public String getArtistName() {
		return artist_name;
	}


	/**
	 * Sets artistName.
	 *
	 * @param artistName the artistName
	 */
	public void setArtistName( String artistName) {
		this.artist_name = artistName;
	}
	
	/**
	 * Gets departementCode.
	 *
	 * @return departementCode
	 */
	public String getDepartementCode() {
		return departmentCode;
	}


	/**
	 * Sets artistName.
	 *
	 * @param artistName the artistName
	 */
	public void setDepartementCode( String departmentCode) {
		this.departmentCode = departmentCode;
	}
	
	
	
	
	
}
