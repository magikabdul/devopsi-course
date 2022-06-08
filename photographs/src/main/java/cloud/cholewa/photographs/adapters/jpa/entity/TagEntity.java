package cloud.cholewa.photographs.adapters.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @Setter
    private String name;

    public TagEntity(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "tags")
    private Set<PhotoEntity> photos = new HashSet<>();

    public void addPhoto(PhotoEntity photoEntity) {
        photos.add(photoEntity);
    }
}
