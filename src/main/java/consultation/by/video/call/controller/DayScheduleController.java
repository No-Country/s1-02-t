package consultation.by.video.call.controller;

import consultation.by.video.call.model.enums.EnumState;
import consultation.by.video.call.model.response.TurnsPatientResponse;
import consultation.by.video.call.service.TurnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/dayschedule")
@Api(value = "controller for dayschedule methods", description = "This API for dayschedules methods")
public class DayScheduleController {
    
   
   
}
//@RequestParam