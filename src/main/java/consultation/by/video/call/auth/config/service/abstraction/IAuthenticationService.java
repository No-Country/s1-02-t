package consultation.by.video.call.auth.config.service.abstraction;

import consultation.by.video.call.auth.config.request.UserAuthenticatedRequest;
import consultation.by.video.call.auth.config.response.UserAuthenticatedResponse;

public interface IAuthenticationService {
    UserAuthenticatedResponse authentication(UserAuthenticatedRequest request);
}
