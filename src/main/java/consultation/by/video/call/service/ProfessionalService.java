package consultation.by.video.call.service;

import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalResponse;
import org.springframework.web.multipart.MultipartFile;


public interface ProfessionalService {
    ProfessionalResponse registerProfessional(ProfessionalRequest request, MultipartFile[] file);
}
