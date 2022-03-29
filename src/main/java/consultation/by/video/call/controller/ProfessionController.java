package consultation.by.video.call.controller;

import consultation.by.video.call.model.request.ProfessionRequest;
import consultation.by.video.call.model.response.ProfessionResponse;
import consultation.by.video.call.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessionResponse create(@RequestBody ProfessionRequest request){
        return professionService.saveProfession(request);
    }

    @GetMapping
    public List<ProfessionResponse> getAllProfessions(){
        return professionService.getProfessions();
    }


}
