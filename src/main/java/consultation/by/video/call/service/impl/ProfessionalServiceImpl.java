package consultation.by.video.call.service.impl;

import consultation.by.video.call.auth.entity.ListRole;
import consultation.by.video.call.auth.service.JwtUtil;
import consultation.by.video.call.auth.service.abstraction.IRoleService;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Role;
import consultation.by.video.call.model.mapper.ProfessionalMapper;
import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalResponse;
import consultation.by.video.call.repository.ProfessionRepository;
import consultation.by.video.call.repository.ProfessionalRepository;
import consultation.by.video.call.service.ProfessionalService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    @Autowired
    private ProfessionalMapper professionalMapper;
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IRoleService roleService;

    @Override
    public ProfessionalResponse registerProfessional(ProfessionalRequest request, MultipartFile[] file) {
        if(professionalRepository.findByEmail(request.getEmail()) != null){
            throw new RuntimeException("El email ya se encuentra registrado.");
        }
        Professional professional = professionalMapper.toEntity(request, file);
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findBy(ListRole.PROFESSIONAL.getFullRoleName()));
        professional.setRoles(roles);
        Professional saved = professionalRepository.save(professional);
        ProfessionalResponse response = professionalMapper.toDto(saved);
        response.setToken(jwtUtil.generateToken(saved));

        return response;
    }
}
