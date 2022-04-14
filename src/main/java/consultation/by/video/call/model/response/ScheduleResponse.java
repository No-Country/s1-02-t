package consultation.by.video.call.model.response;

import consultation.by.video.call.model.entity.DaySchedule;
import consultation.by.video.call.model.enums.EnumState;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ScheduleResponse {
    
    private Long id_professional;
    private String firstName;
    private String lastName;
    private List<DaySchedule> daySchedule;
        
   //daySchedule
//    private Long id_dayschedule;
//    private LocalDate dayMonthYear;//dia del mes   
//    private LocalTime homework; // Inicio del horario laboral de cada profesional
//    private EnumState status;  
}
