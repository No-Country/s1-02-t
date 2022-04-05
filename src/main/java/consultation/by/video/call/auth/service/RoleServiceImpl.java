package consultation.by.video.call.auth.service;

import consultation.by.video.call.model.entity.Role;
import consultation.by.video.call.auth.repository.IRoleRepository;
import consultation.by.video.call.auth.service.abstraction.IRoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findBy(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Role findById(Long id) {
       Optional<Role> role = roleRepository.findById(id);
       if(role.isEmpty()){
        throw new RuntimeException("Rol no encontrado");
     }
     return role.get();   
  }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }    
}
