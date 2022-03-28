package consultation.by.video.call.auth.config.service;


import consultation.by.video.call.auth.config.service.JwtUtil;
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
public class UserServiceImpl  {
//    implements UserDetailsService, IRegisterUserService, IAuthenticationService, IUserService

    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private static final String USER_EMAIL_ERROR = "Email address is already used.";
//
//    @Autowired
//    private JwtUtil jwtUtil;
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Autowired
//    private IRoleService roleService;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private IClientRepository clientRepository;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//
//    @Override
//    public UserRegisterResponse register(UserRegisterRequest request) {
//        if(userRepository.findByEmail(request.getEmail()) != null){
//            throw new RuntimeException(USER_EMAIL_ERROR);
//        }
//        Client user = userMapper.userDto2Entity(request);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        List<Role> roles = new ArrayList<>();
//        roles.add(roleService.findBy(ApplicationRole.USER.getFullRoleName()));
//        user.setRoles(roles);
//
//        Client userCreate = clientRepository.save(user);
//        UserRegisterResponse userRegisterResponse = userMapper.userEntity2Dto(userCreate);
//        userRegisterResponse.setToken(jwtUtil.generateToken(userCreate));
//        return userRegisterResponse;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return getUser(username);
//    }
//
//    private Client getUser(Long id) {
//        Optional<Client> userOptional = clientRepository.findById(id);
//        if (userOptional.isEmpty() || userOptional.get().isSoftDeleted()) {
//            throw new EntityNotFoundException(USER_NOT_FOUND_MESSAGE);
//        }
//        return userOptional.get();
//    }
//
//    private Client getUser(String username) {
//        Client user = clientRepository.findByEmail(username);
//        if (user == null) {
//            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
//        }
//        return user;
//    }
//
//    @Override
//    public UserAuthenticatedResponse authentication(UserAuthenticatedRequest request) {
//        User user = getUser(request.getEmail());
//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
//        return new UserAuthenticatedResponse(jwtUtil.generateToken(user), user.getEmail(), user.getAuthorities());
//    }
//
//
//    @Override
//    public User getInfoUser() throws NotFoundException {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(principal instanceof User){
//            String username = ((User)principal).getUsername();
//        }else{
//            String username = principal.toString();
//        }
//        return userRepository.findByEmail(principal.toString());
//    }
//
//    @Override
//    public void delete(Long id) throws EntityNotFoundException {
//        Client user = getUser(id);
//        user.setSoftDeleted(true);
//        clientRepository.save(user);
//    }
//
//    @Override
//    public UserUpdateResponse update(Long id, UserRegisterRequest request) throws NotFoundException {
//        Optional<Client> entity = clientRepository.findById(id);
//        if(!entity.isPresent()){
//            throw new ParamNotFound("error: id de Cliente no valido");
//        }
//        userMapper.clientEntityRefreshValues(entity.get(), request);
//
//        Client entitySaved = clientRepository.save(entity.get());
//        UserUpdateResponse result = userMapper.userEntity2DtoRefresh(entitySaved);
//        return result;
//    }
//
//    @Override
//    public ClientResponse getById(Long id) {
//        Client client = getUser(id);
//        return userMapper.convertTo(client);
//    }


}
