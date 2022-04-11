package consultation.by.video.call.service.impl;

import consultation.by.video.call.auth.repository.IUserRepository;
import consultation.by.video.call.auth.service.abstraction.IUserService;
import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;
import consultation.by.video.call.repository.ScheduleRepository;
import consultation.by.video.call.service.PatientService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


public class PatientServiceImpl implements PatientService {

    @Autowired
    private IUserRepository userRepository; 
    @Autowired
    private ScheduleRepository scheduleRepository; 
    @Autowired
    private IUserService userService;
    @Override
    public Patient getPatients(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PatientTurnResponse savePatientTurn(PatientTurnRequest request) {
        
        try {
            Patient patient =  (Patient) userService.getInfoUser();
        } catch (NotFoundException ex) {
            Logger.getLogger(PatientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        }
 
}
