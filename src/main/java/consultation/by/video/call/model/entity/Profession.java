package consultation.by.video.call.model.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

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
    List<Professional> professionals;

}
