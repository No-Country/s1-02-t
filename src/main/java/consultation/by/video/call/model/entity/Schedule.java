package consultation.by.video.call.model.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;
    private LocalDate weekday; //lunes, Martes ....
    private LocalDate month; //mes
    private LocalDate year;//año
    private LocalDate dayMonth;//dia del mes
    private LocalTime homework; // Inicio del horario laboral de cada profesional
    private LocalTime endOfWork; //Fin del horario laboral de cada profesional
    @OneToOne
    @JoinColumn(name = "fk_professional", updatable = false, nullable = false)
    private Professional professional;

    public Schedule(LocalTime inicioLaboral, LocalTime finLaboral) {
        this.homework = LocalTime.of(8,0);
        this.endOfWork = LocalTime.of(12,0);
    }


}
