
package consultation.by.video.call.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends User {



    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "patient_professional", joinColumns ={@JoinColumn(name = "idPatient")},
    inverseJoinColumns = {@JoinColumn(name = "idProfessional")})
    private List<Professional> professionals = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Turn> turnList = new ArrayList<>();

    public void addTurn(Turn t){
        turnList.add(t);
    }


}
