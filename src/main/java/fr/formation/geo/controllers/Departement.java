package fr.formation.geo.controllers;

import java.util.Collection;

import javax.persistence.*;

import fr.formation.artist.Artist;

@Entity
@Table(name = "departement")
public class Departement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToMany()
	private Collection<Artist> artist;
	
	@Column(name = "departement_name")
	private String depName;
	
	@Column(name = "code")
	private int code;
	
	
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
	 * Gets DepartementName.
	 *
	 * @return the DepartementName
	 */
	public String getDepatementName() {
		return depName;
	}


	/**
	 * Sets DepartementName.
	 *
	 * @param DepartementName the DepartementName
	 */
	public void setDepartementName(String depName) {
		this.depName = depName;
	}
	
	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}


	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
}
