package consultation.by.video.call.auth.config.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import consultation.by.video.call.auth.entity.ListRole;
import consultation.by.video.call.model.entity.Role;
import consultation.by.video.call.model.entity.User;
import consultation.by.video.call.auth.repository.IRoleRepository;
import consultation.by.video.call.auth.repository.IUserRepository;
import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.entity.Professional;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DataBaseSeeders {

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@test.com";   
    private static final String firstNamePerson[] = 
    {"Gabriel", "Tomas", "Abel",        
    };
     private static final String firstNameAdmin[] = 
    {
    "Ana", "Carlos", "Laura",     
    };
    private static final String firstNameProfessional[] = 
    {
    "Betiana", "Alberto", "Mauricio"    
    };
     
    private static final String lastNamePerson[] = 
    {"Navarro", "Padilla", "Acebedo"};
     private static final String lastNameAdmin[] = 
    { "Miranda", "Aldeano", "Gonzalez" };
     
     private static final String lastNameProfessional[] = 
    { "Gareca", "Quito", "Perez" }; 
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        List<Role> roles = roleRepository.findAll();
        if (roles.isEmpty()) {
            createRoles();
        }

        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            createUsers();
        }

    }

    private void createRoles() {
        createRole(1L, ListRole.USER);
        createRole(2L, ListRole.ADMIN);
        createRole(3L, ListRole.PROFESSIONAL);

    }

    private void createUsers() {         
        createUsers(ListRole.USER, firstNamePerson, lastNamePerson);      
        createAdmin(ListRole.ADMIN,  firstNameAdmin,lastNameAdmin );
        createProfessional(ListRole.PROFESSIONAL, firstNameProfessional, lastNameProfessional);
    }

    private void createUsers(ListRole applicationRole, String[] listName,  String[] lastName) {
          for (int index = 1; index < 4; index++) {
            Patient user=new Patient();        
            user.setFirstName(listName[index-1]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index-1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltrán" + (index-1));
            user.setCountry("Argentina");
            user.setLastName(lastName[index-1]);
            user.setAge((int)(Math.random()*100+1));
            user.setDni(String.valueOf (new Random().nextLong()).substring (9));
            user.setProvince("Mendoza");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
        private void createAdmin(ListRole applicationRole, String[] listName,  String[] lastName) {
          for (int index = 1; index < 4; index++) {
            User user=new User();        
            user.setFirstName(listName[index-1]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index-1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltrán" + (index-1));
            user.setCountry("Argentina");
            user.setLastName(lastName[index-1]);
            user.setAge((int)(Math.random()*100+1));
            user.setDni(String.valueOf (new Random().nextLong()).substring (9));
            user.setProvince("Mendoza");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
    
        private void createProfessional(ListRole applicationRole, String[] listName,  String[] lastName) {
          for (int index = 1; index < 4; index++) {
            Professional user=new Professional();        
            user.setFirstName(listName[index-1]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index-1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltrán" + (index-1));
            user.setCountry("Argentina");
            user.setLastName(lastName[index-1]);
            user.setAge((int)(Math.random()*100+1));
            user.setDni(String.valueOf (new Random().nextLong()).substring (9));
            user.setProvince("Mendoza");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }    
    private void createRole(Long id, ListRole applicationRole) {
        Role role = new Role();
        role.setId(id);
        role.setName(applicationRole.getFullRoleName());
        role.setDescription(applicationRole.getName());
        roleRepository.save(role);
    }

}
