package consultation.by.video.call.auth.entity;

import com.sun.istack.NotNull;
import consultation.by.video.call.model.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
