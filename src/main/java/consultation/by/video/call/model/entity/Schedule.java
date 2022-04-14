package consultation.by.video.call.model.entity;

import consultation.by.video.call.model.enums.EnumState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter @Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private Long id;     
    @OneToOne
    @JoinColumn(name = "fk_professional", updatable = false, nullable = false)
    private Professional professional;
    
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DaySchedule> daySchedule;
    @Enumerated(value = EnumType.STRING)
    private EnumState status;
}
