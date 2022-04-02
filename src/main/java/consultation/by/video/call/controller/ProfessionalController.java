package consultation.by.video.call.controller;

import consultation.by.video.call.model.request.ProfessionalRequest;
import consultation.by.video.call.model.response.ProfessionalResponse;
import consultation.by.video.call.service.ProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
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

}
