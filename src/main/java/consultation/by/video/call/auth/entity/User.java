package consultation.by.video.call.auth.entity;

import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.entity.Person;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends Person {
    @NotNull
    private String password;
    @NotNull
    private String email;   
    @CreationTimestamp
    private Timestamp timestamp;  
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @Column(name = "roles_id")
    private List<Role> roles;
}
