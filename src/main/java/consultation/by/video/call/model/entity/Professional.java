package consultation.by.video.call.model.entity;

import consultation.by.video.call.auth.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Getter @Setter
public class Professional extends User {

    private String registrationNumber;
    private double consultationPrice;


    @ManyToOne
    @JoinColumn(name = "profession_id",insertable = true, updatable = true)
    private Profession profession;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "professionals")
    private List<Patient> patients = new ArrayList<>();




}
