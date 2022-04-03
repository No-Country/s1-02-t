package consultation.by.video.call.service;

import consultation.by.video.call.model.request.ProfessionalAuthenticatedRequest;
import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalAuthenticatedResponse;
import consultation.by.video.call.model.response.ProfessionalListResponse;
import consultation.by.video.call.model.response.ProfessionalResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ProfessionalService {
    ProfessionalResponse registerProfessional(ProfessionalRequest request, MultipartFile[] file);

    ProfessionalAuthenticatedResponse authentication(ProfessionalAuthenticatedRequest request);

    List<ProfessionalListResponse> getAllProfessionals();
}