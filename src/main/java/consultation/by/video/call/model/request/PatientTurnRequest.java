
package consultation.by.video.call.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.enums.EnumState;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PatientTurnRequest {
    //professional  
    @NotNull(message = "You must enter a valid date")
    private String weekday; //lunes, Martes ....
    @JsonFormat(pattern="dd/MM/yyyy")    
    private LocalDate dayMonthYear;//dia del mes
    @JsonFormat(pattern="HH:mm")
    @NotNull(message = "You must enter a valid hour")
    private LocalTime homework; // Inicio del horario laboral de cada profesional
    @JsonFormat(pattern="HH:mm")
    @NotNull(message = "You must enter a valid hour")  
    private LocalTime endOfWork; //Fin del horario laboral de cada profesional  
    private Enum status=EnumState.ACTIVE;
    private double consultationPrice; 
    private Professional professional;
   
    
  
}
