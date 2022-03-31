package consultation.by.video.call.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE profession SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Poneme un Titulo amigo!")
    private String title;

    @Lob
    @Column
    private String description;

    private String imageUrl;

    private boolean deleted;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "professions")
    List<Professional> professionals = new ArrayList<>();



}
