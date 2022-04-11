package consultation.by.video.call.service.impl;

import consultation.by.video.call.auth.repository.IUserRepository;
import consultation.by.video.call.auth.service.abstraction.IUserService;
import consultation.by.video.call.exception.ParamNotFound;
import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Turn;
import consultation.by.video.call.model.mapper.PatientMapper;
import consultation.by.video.call.model.mapper.TurnMapper;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;
import consultation.by.video.call.repository.TurnRepository;
import consultation.by.video.call.service.PatientService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private TurnRepository turnRepository;
    @Autowired
    private IUserService userService;
    @Autowired
    private PatientMapper mapperPatient;
    @Autowired
    private TurnMapper mapperTurn;

    @Override
    public Patient getPatients(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PatientTurnResponse savePatientTurn(PatientTurnRequest request) {
       
        Patient patient;
        try {
            patient = (Patient) userService.getInfoUser();
        } catch (NotFoundException e) {
            throw new ParamNotFound("error: Username is not valid");
        }

        Professional professional = (Professional) userRepository.findById(request.getProfessional().getId()).orElseThrow();
        request.getProfessional().setLastName(professional.getLastName());
        request.getProfessional().setFirstName(professional.getFirstName());        
        PatientTurnResponse patientTurn = mapperPatient.toEntity(request, dayDate(request.getDayMonthYear().toString()));        
        Turn turn =turnRepository.save(mapperTurn.toDTO(patientTurn, professional, patient));
        patientTurns(patient, turn, professional);       
        return patientTurn;
    }

    
    private void patientTurns(Patient patient, Turn t, Professional professional){
        List<Turn> newTurns=patient.getTurnList();
        newTurns.add(t);
        patient.setTurnList(newTurns);
        List<Professional> newProfessional=patient.getProfessionals();
        newProfessional.add(professional);
        patient.setProfessionals(newProfessional);
        userRepository.save(patient);        
    }
    
    
    
    private String dayDate(String date) {
        String day = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCurrent = null;
        try {
            dateCurrent = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar dateCalendar = new GregorianCalendar();
        dateCalendar.setTime(dateCurrent);
        int dayWeek = dateCalendar.get(Calendar.DAY_OF_WEEK);
        
        switch (dayWeek) {
            case 1: day= "Domingo";
                break;
            case 2: day = "Lunes";
                break;
            case 3: day = "Martes";
                break;
            case 4: day = "Miércoles";
                break;
            case 5: day = "Juevess";
                break;
            case 6: day = "Viernes";
                break;
            case 7: day = "Sábado";
                break;
            default:
                throw new AssertionError();
        }        
        return day;
    }

}
