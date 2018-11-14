package fr.formation.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

import fr.formation.user.User;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne()
	private User user;
	
	@Lob
	@Column(name = "imageName")
	private byte[] imageName;
	
	@Column(name = "path")
	private String path;
	
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
	 * Gets path.
	 *
	 * @return the id
	 */
	public String getPath() {
		return path;
	}


	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Gets ImageName.
	 *
	 * @return the ImageName
	 */
	public byte[] GetImageName() {
		return imageName; 
	}
	
	/**
	 * Sets imageName.
	 *
	 * @param imageName 
	 */
	public void setImageName( byte[] imageName) {
		this.imageName = imageName;
	}
}
