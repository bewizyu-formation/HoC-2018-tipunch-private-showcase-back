package fr.formation.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import fr.formation.artist.Artist;


/**
 * The type UserInfoDTO.
 */
public class UserInfoDTO implements Serializable {
	
	private static final long serialVersionUID = -5639803855314477341L;
	
	@NotNull
    private Long id;
	@NotNull
	private @NotNull User username;
	
	@NotNull
	private Artist artist_name;
	
	@NotNull
	private String departmentCode;
	
	public UserInfoDTO(@NotNull User user, @NotNull Artist artist, @NotNull String departmentCode) {
		super();
		this.username = user;
		this.artist_name = artist;
		this.departmentCode = departmentCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	/**
	 * Gets username.
	 *
	 * @return the username
	 */
	public @NotNull User getuserName() {
		return username;
	}

	/**
	 * Sets username.
	 *
	 * @param username the username
	 */
	public void setUserName( User username) {
		this.username = username;
	}
	
	/**
	 * Gets artistName.
	 *
	 * @return artistName
	 */
	public @NotNull Artist getArtistName() {
		return artist_name;
	}


	/**
	 * Sets artistName.
	 *
	 * @param artistName the artistName
	 */
	public void setArtistName( Artist artistName) {
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
