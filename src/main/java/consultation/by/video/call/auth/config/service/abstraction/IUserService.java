package consultation.by.video.call.auth.config.service.abstraction;


import consultation.by.video.call.auth.config.entity.User;
import consultation.by.video.call.auth.config.request.UserRegisterRequest;
import javassist.NotFoundException;

import javax.persistence.EntityNotFoundException;

public interface IUserService {
    User getInfoUser() throws NotFoundException;

    void delete(Long id)throws EntityNotFoundException;

//    UserUpdateResponse update(Long id, UserRegisterRequest request)throws NotFoundException;

//
//    ClientResponse getById(Long id);
}
