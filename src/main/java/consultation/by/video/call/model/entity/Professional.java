package consultation.by.video.call.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE professional SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@NoArgsConstructor
@Getter @Setter
public class Professional extends User {


    private String enrollment;
    private double consultationPrice;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "professionals")
    private List<Patient> patients = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id",insertable = true)
    private Profession professions;

    @OneToOne (mappedBy = "professional", cascade = CascadeType.ALL)
    private Schedule schedule;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Turn> turnList = new ArrayList<>();

    public void addTurn(Turn t){
        turnList.add(t);
    }

}
