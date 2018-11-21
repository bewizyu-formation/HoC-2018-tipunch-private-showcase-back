package fr.formation.upload;

import javax.persistence.*;


@Entity
@Table(name="image")
public class Image {

    public void Image() {}

    public Image(String img_name, String img_path) {
        this.img_name = img_name;
        this.img_path = img_path;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String img_name;

    @Column(unique = true, nullable = false)
    private String img_path;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }
}
