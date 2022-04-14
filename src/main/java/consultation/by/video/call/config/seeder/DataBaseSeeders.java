package consultation.by.video.call.config.seeder;

import consultation.by.video.call.model.entity.*;
import consultation.by.video.call.model.enums.EnumState;
import consultation.by.video.call.model.response.PatientsReponse;
import consultation.by.video.call.model.response.ProfessionResponse;
import consultation.by.video.call.repository.*;
import consultation.by.video.call.service.PatientService;
import consultation.by.video.call.service.ProfessionService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataBaseSeeders {

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@test.com";
    private static final String firstNameUser[] = {"Gabriel", "Abel", "Tomas"};
    private static final String firstNamePatient[] = {"Laura", "Raquel", "Roberto","Abel","Tomas"};
    private static final String firstNameProfessional[] = {"Tomas", "Eduardo", "Caro","Abel","Fernando"};
    private static final String lastNameUser[] = {"Navarro", "Acevedo", "Padilla"};
    private static final String lastNameProfessional[] = {"Caruana", "Lopez", "Nose","Acevedo","Vals"};
    private static final String lastNamePatient[] = {"Sanchez", "Lepez", "Astudillo","Prigioni","Bubien"};
    private final Profession [] professionsList = {
            new Profession(1L, "Psicología","Tratamientos para la ansiedad, depresión, stress, parejas. Y mucho más...",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsicologia.jpeg?alt=media&token=77cde0cd-69ab-4743-89bf-2bb51b7930a2",   false),
            new Profession(2L, "Oncología","Es la rama de la medicina que estudia y trata las neoplasias, con especial atención a los tumores malignos o cáncer.",
                    "https://storage.googleapis.com/s1-02-t.appspot.com/eaa5ce64-f012-4e59-b994-e443458c105cjpg",   false),
            new Profession(3L, "Diabetología","Subespecialidad médica que se encarga de la prevención, diagnóstico y tratamiento de los pacientes con Diabetes, enfermedad caracterizada por el aumento de azúcar en la sangre (glicemia).",
                    "https://storage.googleapis.com/s1-02-t.appspot.com/f8622251-4d2d-46f3-b8f5-0361b3e699d5jpg",   false),
            new Profession(4L, "Psicopedagogía","La psicopedagogía o psicopedagógica es una disciplina que estudia a las personas y sus comportamientos en situación de enseñanza-aprendizaje.",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsicoPedagogia.jpeg?alt=media&token=1e828492-b401-4a0e-97fc-1e42ae5c56ab",   false),
            new Profession(5L, "Psiquiatría","Es la especialidad médica dedicada al estudio de los trastornos mentales de origen genético o neurológico con el objetivo de prevenir, evaluar, diagnosticar, tratar y rehabilitar a las personas con trastornos mentales, y asegurar la autonomía y la adaptación del individuo a las condiciones de su existencia.",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsiquiatria.avif?alt=media&token=21273673-a39d-42f7-90de-1d832ab99201"
            ,   false),
    };
   
    private  final ProfessionRepository professionRepository;
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;   
    private final PasswordEncoder passwordEncoder;
    private final TurnRepository turnRepository;
    private final PatientRepository patientRepository;
    private final ProfessionalRepository professionalRepository;
    

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {       
        if (roleRepository.findAll().isEmpty()) {
            createRoles();
        }

        if(professionRepository.findAll().isEmpty()){
            createProfessions();
        }

        if(professionRepository.findAll().isEmpty())
            createProfessions();       
        
        if (userRepository.findAll().isEmpty()) {
            createUsers();
        }

        if(turnRepository.findAll().isEmpty()){
            createTurns();
        }

    }
    // TODO version de prueba, en este mismo metodo se le puede asignar el turno al professional
    // TODO hay que agregarle al response que devuelva la lista de turnos del professional

    private void createTurns() {
        List<Patient> patients = patientRepository.findAll();
        List<Professional> professionals = professionalRepository.findAll();
        for(long i = 0; i < 5; i++){
            Turn turn = new Turn(i,LocalDate.now(),LocalTime.now(),EnumState.ACTIVED, professionals.get((int) i),patients.get((int) i),false);
            turnRepository.save(turn);
           // professionals.get((int) i).addTurn(turn);
        }
    }

    private void createRoles() {
        createRole(1L, ListRole.USER);
        createRole(2L, ListRole.ADMIN);
        createRole(3L, ListRole.PROFESSIONAL);
        createRole(4L, ListRole.PATIENT);
    }

    private void createProfessions() {
        for (Profession profession : professionsList) {
            professionRepository.save(profession);
        }
        
    };

    private void createUsers(){
        createUsers(ListRole.ADMIN);
        createPatient(ListRole.PATIENT);
        createProfessional(ListRole.PROFESSIONAL);
    }

    private Integer calcAge() {
        return (int) (Math.random() * (90 - 18 + 1) + 18);
    }

    private String calcDni() {
        Integer num = (int) (Math.random() * (99000000 - 10000000 + 1) + 10000000);
        return num.toString();
    }

    private void createUsers(ListRole applicationRole) {

        for (int index = 0; index < 3; index++) {
            User user = new User();
            user.setFirstName(firstNameUser[index]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index + 1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltran ");
            user.setCountry("Argentina");
            user.setLastName(lastNameUser[index]);
            user.setAge(calcAge());
            user.setDni(calcDni());
            user.setProvince("Mendoza");
            user.setRoles(createListRole(applicationRole));
            userRepository.save(user);

        }
    }

    private List<Role> createListRole(ListRole applicationRole) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
        return roles;
    }

    private void createPatient(ListRole applicationRole) {

        for (int index = 0; index < 5; index++) {
            Patient user = new Patient();
            user.setFirstName(firstNamePatient[index]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index + 1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltran ");
            user.setCountry("Argentina");
            user.setLastName(lastNamePatient[index]);
            user.setAge(calcAge());
            user.setDni(calcDni());
            user.setProvince("Mendoza");
            user.setRoles(createListRole(applicationRole));
            user.setMaritalStatus("Soltero");
            user.setOccupation("Maestro");
            user.setReligion("Catolico");           
            userRepository.save(user);

        }
    }

    private void createProfessional(ListRole applicationRole) {
        List<Profession> professions = professionRepository.findAll();
        for (int index = 0; index < professions.size(); index++) {
            Professional user = new Professional();
            user.setFirstName(firstNameProfessional[index]);
            user.setEmail(applicationRole.getName().toLowerCase() + (index + 1) + HOST_EMAIL);
            user.setPassword(passwordEncoder.encode(PASSWORD));
            user.setCity("Beltran ");
            user.setCountry("Argentina");
            user.setLastName(lastNameProfessional[index]);
            user.setAge(calcAge());
            user.setDni(calcDni());
            user.setProvince("Mendoza");
            user.setRoles(createListRole(applicationRole));
            user.setConsultationPrice(calcAge()*100.3);           
            user.setProfessions(professions.get(index));
            user.setEnrollment(calcDni());
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
