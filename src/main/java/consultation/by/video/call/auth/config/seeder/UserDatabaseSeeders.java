package consultation.by.video.call.auth.config.seeder;

import consultation.by.video.call.model.entity.Profession;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.repository.ProfessionRepository;
import consultation.by.video.call.service.FirebaseService;
import consultation.by.video.call.service.impl.FirebaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDatabaseSeeders {




    private final Profession professionsList[] ={
            new Profession(1L, "Psicólogo","Tratamientos para la ansiedad, depresión, stress, parejas.",
                    null,   false, new ArrayList<>()),
            new Profession(2L, "Oncology","Tratamientos para cancer.",
                    null,   false, new ArrayList<>())
    };

    @Autowired
    private ProfessionRepository professionRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        List<Profession> professions = professionRepository.findAll();
        if(professions.isEmpty())
            createProfessions();
    }

    private void createProfessions() {
       for(Profession p: professionsList){
           professionRepository.save(p);
       }
    }

}
