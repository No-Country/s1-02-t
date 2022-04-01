package consultation.by.video.call.auth.service.abstraction;


import consultation.by.video.call.model.entity.User;
import consultation.by.video.call.auth.request.UserRequest;
import consultation.by.video.call.auth.response.RoleResponse;
import consultation.by.video.call.auth.response.UserResponse;
import consultation.by.video.call.auth.response.UserRoleResponse;
import java.util.List;
import javassist.NotFoundException;
import javax.persistence.EntityNotFoundException;

public interface IUserService {
    
    User getInfoUser() throws NotFoundException;
    void delete(Long id)throws EntityNotFoundException;
    UserResponse update(Long id, UserRequest request)throws NotFoundException;
    UserResponse getById(Long id);
    List<UserResponse> getAllUser();
    UserRoleResponse updateRole(Long id, String roleName);
}
