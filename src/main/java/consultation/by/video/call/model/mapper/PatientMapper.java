package consultation.by.video.call.model.mapper;


import consultation.by.video.call.model.enums.EnumState;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientTurnResponse toEntity(PatientTurnRequest dto, String dayName) {
            return PatientTurnResponse.builder()
                .consultationPrice(dto.getConsultationPrice())
                .lastName(dto.getProfessional().getLastName())
                .firstName(dto.getProfessional().getFirstName())
                .professional_id(dto.getProfessional().getId())
                .dayMonthYear(dto.getDayMonthYear())
                .homework(dto.getHomework())
                .weekday(dayName)
                .status(EnumState.ACTIVED)
                .build();
        
    }

//    public ProfessionResponse toDTO(Profession entity) {
//        return ProfessionResponse.builder()
//                .id(entity.getId())
//                .title(entity.getTitle())
//                .description(entity.getDescription())
//                .imageUrl(entity.getImageUrl())
//                .build();
//    }
}
