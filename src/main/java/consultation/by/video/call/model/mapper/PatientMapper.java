package consultation.by.video.call.model.mapper;

import consultation.by.video.call.model.entity.Profession;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.request.ProfessionRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;
import consultation.by.video.call.model.response.ProfessionResponse;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientTurnResponse toEntity(PatientTurnRequest dto) {
        return PatientTurnResponse.builder()
                .consultationPrice(dto.getConsultationPrice())
                //ver datos necesarios para turno
                .build();
    }

    public ProfessionResponse toDTO(Profession entity) {
        return ProfessionResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .imageUrl(entity.getImageUrl())
                .build();
    }
}
