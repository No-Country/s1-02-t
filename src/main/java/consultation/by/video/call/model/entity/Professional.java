package consultation.by.video.call.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Professional extends User{

    @Column(name = "registration_number")
    private String registrationNumber;
    @Column(name = "consultation_price")
    private double consultationPrice;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "patient_professional", joinColumns = @JoinColumn(
            name = "id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Patient> patients = new ArrayList<>();


}
