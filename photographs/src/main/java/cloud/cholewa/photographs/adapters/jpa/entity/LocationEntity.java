package cloud.cholewa.photographs.adapters.jpa.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locations")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Setter
    private String name;

    @Transient
    private String shortName;

    public LocationEntity(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "location")
    private Set<PhotoEntity> photos = new HashSet<>();

    public void addPhoto(PhotoEntity photoEntity) {
        photos.add(photoEntity);
    }

    @PostLoad
    private void postLoad() {
        if (name.length() < 5) {
            shortName = name;
        } else {
            shortName = name.substring(0, 5);
        }
    }
}
