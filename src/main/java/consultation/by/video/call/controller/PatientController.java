package consultation.by.video.call.controller;

import consultation.by.video.call.auth.service.abstraction.IUserService;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.service.ProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/patient")
@Api(value = "controller for patient methods", description = "This API for patient methods")
public class PatientController {
    
    @Autowired
    private IUserService userService;
    @Autowired
    private ProfessionalService professionalService;
    
    @PostMapping("prof_turn/{id}")
    @ApiOperation(value = "Update info patient  & professional", notes = "Return patient" )
    public ResponseEntity<?> updatePatient(@RequestPart(value = "professional", required = true)  Professional professional 
            ) throws NotFoundException{  
    
        // retorna profesional segun profesion getProfessionalByProfessionalId
        // getProfessional segun id retorna profesional
        
        return ResponseEntity.ok().body(null);//userService.update(id, request));
    }
        
//        FormLineProduct formLineProduct = new FormLineProduct();
//        formLineProduct.setLineProduct(formLineCart);
//
//        Client client = (Client) userService.getInfoUser();
//
//        ResponseEntity<?> response = cartService.createCart(client, formLineProduct.getLineProduct());
//        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    } 

