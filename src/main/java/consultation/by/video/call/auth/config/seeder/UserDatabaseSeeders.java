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


    private final Profession [] professionsList ={
            new Profession(1L, "Psicólogo","Tratamientos para la ansiedad, depresión, stress, parejas.",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsicologia.jpeg?alt=media&token=77cde0cd-69ab-4743-89bf-2bb51b7930a2",   false, new ArrayList<>()),
            new Profession(2L, "Oncología","Es la rama de la medicina que estudia y trata las neoplasias, con especial atención a los tumores malignos o cáncer.",
                    "https://storage.googleapis.com/s1-02-t.appspot.com/eaa5ce64-f012-4e59-b994-e443458c105cjpg",   false, new ArrayList<>()),
            new Profession(3L, "Diabetología","Subespecialidad médica que se encarga de la prevención, diagnóstico y tratamiento de los pacientes con Diabetes, enfermedad caracterizada por el aumento de azúcar en la sangre (glicemia).",
                    "https://storage.googleapis.com/s1-02-t.appspot.com/f8622251-4d2d-46f3-b8f5-0361b3e699d5jpg",   false, new ArrayList<>()),
            new Profession(4L, "Psicopedagogía","La psicopedagogía o psicopedagógica es una disciplina que estudia a las personas y sus comportamientos en situación de enseñanza-aprendizaje.",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsicoPedagogia.jpeg?alt=media&token=1e828492-b401-4a0e-97fc-1e42ae5c56ab",   false, new ArrayList<>()),
            new Profession(5L, "psiquiatría","Es la especialidad médica dedicada al estudio de los trastornos mentales de origen genético o neurológico con el objetivo de prevenir, evaluar, diagnosticar, tratar y rehabilitar a las personas con trastornos mentales, y asegurar la autonomía y la adaptación del individuo a las condiciones de su existencia.",
                    "https://firebasestorage.googleapis.com/v0/b/s1-02-t.appspot.com/o/imagePsiquiatria.avif?alt=media&token=21273673-a39d-42f7-90de-1d832ab99201"
            ,   false, new ArrayList<>()),
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