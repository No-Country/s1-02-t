package consultation.by.video.call.service;

import consultation.by.video.call.model.entity.Patient;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;

public interface  PatientService {
   Patient getPatients(Long Id);
   PatientTurnResponse savePatientTurn(PatientTurnRequest request);

}
