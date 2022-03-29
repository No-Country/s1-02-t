package consultation.by.video.call.model.entity;

import consultation.by.video.call.auth.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Professional extends User {

    private String registrationNumber;
    private double consultationPrice;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "professional_profession", joinColumns ={@JoinColumn(name = "idProfessional")},
            inverseJoinColumns = {@JoinColumn(name = "idProfession")})
    private List<Profession> professions = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "professionals")
    private List<Patient> patients = new ArrayList<>();





}
