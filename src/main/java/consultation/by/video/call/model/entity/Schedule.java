package consultation.by.video.call.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import consultation.by.video.call.model.enums.EnumState;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotNull;
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
    @ManyToOne
    @JoinColumn(name = "fk_professional", updatable = false, nullable = false)
    private Professional professional;
    @JsonFormat(pattern="dd/MM/yyyy")    
    private LocalDate dayMonthYear;//dia del mes
    
    @JsonFormat(pattern="HH:mm")
    @NotNull(message = "You must enter a valid hour")
    @OneToMany ()
    private List<DaySchedule> homeWork;// Inicio del horario laboral de cada profesional    
    
   
}
