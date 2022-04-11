package consultation.by.video.call.model.mapper;

import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Turn;
import consultation.by.video.call.model.enums.EnumState;
import consultation.by.video.call.model.response.PatientTurnResponse;

import org.springframework.stereotype.Component;
@Component
public class TurnMapper {
   
    public Turn toDTO(PatientTurnResponse entity, Professional professional, Patient patient) {
        
        return Turn.builder()
                .day(entity.getDayMonthYear())
                .hour(entity.getHomework())
                .high(EnumState.ACTIVED)                                
                .professional(professional)
                .patient(patient)
                .build();
    }
    
//        private String weekday;     
//    private LocalDate dayMonthYear;//dia del mes  
//    private LocalTime homework; // Inicio del horario laboral de cada profesional    
//    private Enum status=EnumState.ACTIVE;
//    private double consultationPrice; 
//    //professional
//    private Long professional_id;
//    private String lastName;
//    private String firstName;
//    private Double price;
//    
    
//    private LocalDate day; //date full
//    private LocalTime hour;
//    private Enum high=EnumState.ADVANCED;//alta   
//    private Professional professional;   
//    private Patient patient; //ver
//    private boolean deleted; //ver
}
