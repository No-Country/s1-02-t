package consultation.by.video.call.auth.mapper;

import consultation.by.video.call.auth.entity.User;
import consultation.by.video.call.auth.request.UserRegisterRequest;
import consultation.by.video.call.auth.response.RoleResponse;
import consultation.by.video.call.auth.response.UserRegisterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    @Autowired
    private PasswordEncoder passwordEncoder;


    public User userDto2Entity(UserRegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setAge(request.getAge());
        user.setCity(request.getCity());
        user.setCountry(request.getCountry());
        user.setDni(request.getDni());
        user.setFirstName(request.getFirst_name());
        user.setLastName(request.getLast_name());
        user.setImageUrl(null);
        user.setProvince(request.getProvince());
        user.setRoles(null);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;        
    }

    public UserRegisterResponse userEntity2Dto(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setFirstName(user.getFirstName());
        userRegisterResponse.setLastName(user.getLastName());
        userRegisterResponse.setEmail(user.getEmail());
        userRegisterResponse.setRoles(new RoleResponse(user.getRoles().get(0).getId(), user.getRoles().get(0).getName()));
       
        return userRegisterResponse;
    }
//
//    public void clientEntityRefreshValues(Client client, UserRegisterRequest request) {
//        client.setUsername(request.getUsername());
//        client.setEmail(request.getEmail());
//
//        client.setPassword(passwordEncoder.encode(request.getPassword()));
//        client.setName(request.getName());
//        client.setSurname(request.getSurname());
//        client.setCity(request.getCity());
//        client.setCountry(request.getCountry());
//        client.setState(request.getState());
//        ImageProfile imageProfile = fileUploadService.uploadImageProfileToDB(request.getImageProfile());
//        client.setImageProfile(imageProfile);
//
//    }
//
//    public UserUpdateResponse userEntity2DtoRefresh(Client entity) {
//       UserUpdateResponse dto = new UserUpdateResponse();
//        dto.setUsername(entity.getUsername());
//        dto.setEmail(entity.getEmail());
//        dto.setName(entity.getName());
//        dto.setSurname(entity.getSurname());
//        dto.setCity(entity.getCity());
//        dto.setCountry(entity.getCountry());
//        dto.setState(entity.getState());
//        dto.setImageProfile(entity.getImageProfile());
//        return dto;
//    }
//
//    public ClientResponse convertTo(Client client) {
//        ClientResponse clientResponse = new ClientResponse();
//        clientResponse.setId(client.getId());
//        clientResponse.setName(client.getName());
//        clientResponse.setUsername(client.getUsername());
//        clientResponse.setCity(client.getCity());
//        clientResponse.setCountry(client.getCountry());
//        clientResponse.setEmail(client.getEmail());
//        clientResponse.setPassword(client.getPassword());
//        clientResponse.setState(client.getState());
//        clientResponse.setSurname(clientResponse.getSurname());
//
//        return clientResponse;
//    }
}
