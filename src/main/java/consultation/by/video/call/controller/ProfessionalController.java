package consultation.by.video.call.controller;

import consultation.by.video.call.model.request.ProfessionalAuthenticatedRequest;
import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalAuthenticatedResponse;
import consultation.by.video.call.model.response.ProfessionalListResponse;
import consultation.by.video.call.model.response.ProfessionalResponse;
import consultation.by.video.call.service.ProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professional")
@Api(value = "Authenticate professional", description = "This API has a Authenticated for professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalService service;

    @PostMapping("/register")
    @ApiOperation(value = "Register Professional", notes = "Return a professional register" )
    public ResponseEntity<ProfessionalResponse> registerProfessional(@ModelAttribute ProfessionalRequest request, MultipartFile[] file){
        ProfessionalResponse response = service.registerProfessional(request, file);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login Professional", notes = "Return token, email, roleName" )
    public ResponseEntity<ProfessionalAuthenticatedResponse> login(@Valid @RequestBody ProfessionalAuthenticatedRequest request){
        ProfessionalAuthenticatedResponse response = service.authentication(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProfessionalListResponse>> getAllProfessionals(){
        List<ProfessionalListResponse> response = service.getAllProfessionals();
        return ResponseEntity.ok().body(response);
    }


}