package fr.formation.image;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.*;

import fr.formation.artist.Artist;

@Entity
public class Image {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String img_name;
	
	@Column(unique = true, nullable = false)
	private String img_path;
	
//	@OneToOne
//	private Artist artist;
	
	
	/**
	 * Image Constructor.
	 * @param id
	 * @param img_name
	 * @param img_path
	 * @param artist
	 */
	public Image(Long id, String img_name, String img_path, Artist artist) {
		this.id = id;
		this.img_name = img_name;
		this.img_path = img_path;
//		this.artist = artist;
	}
	
	
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
	 * @return the image path
	 */
	public String getImagePath() {
		return img_path;
	}

	/**
	 * Sets image path.
	 *
	 * @param path the path
	 */
	public void setImagePath(String path) {
		this.img_path = path;
	}
	
	/**
	 * Gets Image's Name.
	 *
	 * @return the ImageName
	 */
	public String GetImageName() {
		return img_name; 
	}
	
	/**
	 * Sets image's name.
	 *
	 * @param imageName 
	 */
	public void setImageName(String imageName) {
		this.img_name = imageName;
	}
}
