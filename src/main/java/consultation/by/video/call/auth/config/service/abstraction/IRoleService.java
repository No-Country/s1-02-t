package consultation.by.video.call.auth.config.service.abstraction;

import consultation.by.video.call.auth.config.entity.Role;

public interface IRoleService {
    Role findByName(String name);
}
