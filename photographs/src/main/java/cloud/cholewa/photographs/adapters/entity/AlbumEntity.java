package cloud.cholewa.photographs.adapters.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "albums")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;
    private int views;

    @OneToMany(mappedBy = "album")
    private List<PhotoEntity> photos;
}
