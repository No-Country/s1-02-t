package consultation.by.video.call.auth.service;


import consultation.by.video.call.auth.entity.ListRole;
import consultation.by.video.call.auth.entity.Role;
import consultation.by.video.call.auth.entity.User;
import consultation.by.video.call.auth.service.abstraction.IAuthenticationService;
import consultation.by.video.call.auth.service.abstraction.IUserService;
import consultation.by.video.call.auth.service.abstraction.IRegisterUserService;
import consultation.by.video.call.auth.mapper.UserMapper;
import consultation.by.video.call.auth.repository.IUserRepository;
import consultation.by.video.call.auth.request.UserAuthenticatedRequest;
import consultation.by.video.call.auth.request.UserRegisterRequest;
import consultation.by.video.call.auth.response.UserAuthenticatedResponse;
import consultation.by.video.call.auth.response.UserRegisterResponse;
import consultation.by.video.call.auth.service.JwtUtil;
import consultation.by.video.call.auth.service.abstraction.IRoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserDetailsService, IRegisterUserService, IAuthenticationService, IUserService  {
//   
    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private static final String USER_EMAIL_ERROR = "Email address is already used.";

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private IClientRepository clientRepository;

    @Autowired
    private AuthenticationManager authenticationManager;



    @Override
    public UserRegisterResponse register(UserRegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()) != null){
            throw new RuntimeException(USER_EMAIL_ERROR);
        }
        User user = userMapper.userDto2Entity(request);  
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findBy(ListRole.USER.getFullRoleName()));
        user.setRoles(roles);  
          System.out.println("EL ROL ES : "+user.getRoles().get(0) );
        User userCreate = userRepository.save(user);
        UserRegisterResponse userRegisterResponse = userMapper.userEntity2Dto(userCreate);
        userRegisterResponse.setToken(jwtUtil.generateToken( userCreate));
        return userRegisterResponse;      
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) getUser(email);
    }

    private User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return userOptional.get();
    }
//
    private User getUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return user;
    }

    @Override
    public UserAuthenticatedResponse authentication(UserAuthenticatedRequest request) {
        User user = getUser(request.getEmail());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        return new UserAuthenticatedResponse(jwtUtil.generateToken((UserDetails) user), user.getEmail(), user.getAuthorities());
    }


    @Override
    public User getInfoUser() throws NotFoundException {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof User){
            String username = ((User) principal).getDni();
        }else{
            String username = principal.toString();
        }
        return userRepository.findByEmail(principal.toString());
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        User user = getUser(id);
       //auditoria
        userRepository.save(user);
    }

//    @Override
//    public UserUpdateResponse update(Long id, UserRegisterRequest request) throws NotFoundException {
//        Optional<User> entity = userRepository.findById(id);
//        if(!entity.isPresent()){
//            throw new ParamNotFound("error: id de Usuario no es valido");
//        }
//        userMapper.clientEntityRefreshValues(entity.get(), request);
//
//        Client entitySaved = clientRepository.save(entity.get());
//        UserUpdateResponse result = userMapper.userEntity2DtoRefresh(entitySaved);
//        return result;
//    }

//    @Override
//    public ClientResponse getById(Long id) {
//        Client client = getUser(id);
//        return userMapper.convertTo(client);
//    }


}
