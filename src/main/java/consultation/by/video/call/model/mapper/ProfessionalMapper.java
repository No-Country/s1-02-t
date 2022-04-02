package consultation.by.video.call.model.mapper;

import consultation.by.video.call.model.entity.Person;
import consultation.by.video.call.model.entity.Profession;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.User;
import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalResponse;
import consultation.by.video.call.service.FirebaseService;
import consultation.by.video.call.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ProfessionalMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FirebaseService service;
    @Autowired
    private ProfessionService professionService;

    public Professional toEntity(ProfessionalRequest request, MultipartFile[] file) {
        String imageUrl = service.subirImagen(file);
        Professional p = new Professional();
        p.setEmail(request.getEmail());
        p.setAge(request.getAge());
        p.setCity(request.getCity());
        p.setCountry(request.getCountry());
        p.setDni(request.getDni());
        p.setFirstName(request.getFirst_name());
        p.setLastName(request.getLast_name());
        p.setImageUrl(imageUrl);
        p.setProvince(request.getProvince());
        p.setPassword(passwordEncoder.encode(request.getPassword()));
        p.setConsultationPrice(request.getConsultationPrice());
        p.setEnrollment(request.getEnrollment());
        Profession profession = professionService.getProfession(request.getProfessionId());
        p.setProfessions(profession);
        return p;
    }

    public ProfessionalResponse toDto(Professional saved) {
        ProfessionalResponse response= new ProfessionalResponse();
        response.setEmail(saved.getEmail());
        response.setFirstName(saved.getFirstName());
        response.setLastName(saved.getLastName());
        response.setId(saved.getId());
        response.setImageUrl(saved.getImageUrl());
        return response;
    }
}
