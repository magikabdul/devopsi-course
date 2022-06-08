package cloud.cholewa.photographs.adapters.entity;

import cloud.cholewa.photographs.domain.PrivacyType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "photos")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private PrivacyType privacy;

    private int views;

    @Embedded
    private Uploader uploadHistory;

    @ManyToOne
    private AlbumEntity album;

    @ManyToMany
    private Set<TagEntity> tags;

    @OneToMany(mappedBy =  "photo")
    private Set<CommentEntity> comments;

    @ManyToOne
    private LocationEntity location;
}
