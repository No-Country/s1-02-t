package consultation.by.video.call.service;

import consultation.by.video.call.model.entity.Role;
import java.util.List;

public interface IRoleService {
    Role findBy(String name);
    Role findById(Long id);
    List<Role> findAll();
}
