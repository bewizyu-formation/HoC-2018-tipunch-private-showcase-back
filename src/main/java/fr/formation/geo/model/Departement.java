package fr.formation.geo.model;

import java.io.Serializable;

/**
 * The type Departement.
 */
public class Departement implements Serializable {

	private String nom;

	private String code;

	/**
	 * Create a Departement
	 *
	 * @param nom  the nom
	 * @param code the code
	 */
	public Departement(String nom, String code) {
		this.nom = nom;
		this.code = code;
	}

	/**
	 * Create a Departement
	 */
	public Departement() {
	}

	/**
	 * Gets nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets nom.
	 *
	 * @param nom the nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
