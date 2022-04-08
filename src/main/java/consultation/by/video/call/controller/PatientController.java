package consultation.by.video.call.controller;

import consultation.by.video.call.auth.service.abstraction.IUserService;
import consultation.by.video.call.model.request.PatientTurnRequest;
import consultation.by.video.call.model.response.PatientTurnResponse;
import consultation.by.video.call.service.PatientService;
import consultation.by.video.call.service.ProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/patient")
@Api(value = "controller for patient methods", description = "This API for patient methods")
public class PatientController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ProfessionalService professionalService;
    @Autowired
    private PatientService patientService;

    @PostMapping("/turn_patient")
    @ApiOperation(value = "Add info Turn patient  & professional", notes = "Return patient")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientTurnResponse createTurnPatient(@Valid @RequestBody PatientTurnRequest request) {
        return patientService.savePatientTurn(request);
    }
}
