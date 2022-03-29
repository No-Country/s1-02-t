package consultation.by.video.call.auth.service.abstraction;

import consultation.by.video.call.auth.entity.Role;

public interface IRoleService {
    Role findBy(String name);
}
