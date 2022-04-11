package consultation.by.video.call.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.enums.EnumState;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientTurnResponse {
  
    private String weekday;      
    private LocalDate dayMonthYear;//dia del mes   
    private LocalTime homework; // Inicio del horario laboral de cada profesional   
    private LocalTime endOfWork; //Fin del horario laboral de cada profesional  
    private Enum status=EnumState.ACTIVE;
    private double consultationPrice; 
    private Professional professional;
   
}
