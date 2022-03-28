package consultation.by.video.call.auth.config.service.abstraction;

import consultation.by.video.call.auth.config.request.UserRegisterRequest;
import consultation.by.video.call.auth.config.response.UserRegisterResponse;



public interface IRegisterUserService {

    UserRegisterResponse register(UserRegisterRequest request);
}
