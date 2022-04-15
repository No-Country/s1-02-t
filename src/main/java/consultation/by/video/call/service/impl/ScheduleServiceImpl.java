package consultation.by.video.call.service.impl;

import consultation.by.video.call.exception.ParamNotFound;
import consultation.by.video.call.model.entity.DaySchedule;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Schedule;
import consultation.by.video.call.model.mapper.ScheduleMapper;
import consultation.by.video.call.model.request.ScheduleRequest;
import consultation.by.video.call.model.response.ScheduleResponse;
import consultation.by.video.call.repository.DayScheduleRepository;
import consultation.by.video.call.repository.ScheduleRepository;
import consultation.by.video.call.service.IUserService;
import consultation.by.video.call.service.ScheduleService;
import java.util.ArrayList;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private IUserService userService;
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired 
    private DayScheduleRepository dayScheduleRepository;
    
     @Autowired 
    private ScheduleRepository scheduleRepository;
     
    @Override
    public ScheduleResponse save(ScheduleRequest request) {
       Professional professional;
        try {
            professional = (Professional) userService.getInfoUser();
        } catch (NotFoundException e) {
            throw new ParamNotFound("error: Username is not valid");
        }
        System.out.println("LLEGA ACAA PRIMERO");
        List<DaySchedule> daySchedule=new ArrayList<>();
        
       
        
      Schedule s=new Schedule();
      s.setDayMonthYear(request.getDay());
      s.setProfessional(professional);
      s.setHomeWork(daySchedule);
      scheduleRepository.save(s);
       for (int i = 0; i < request.getHours().size() ; i++) {            
           
            DaySchedule day=new DaySchedule(request.getHours().get(i),request.getStatus(),s);            
            daySchedule.add(day) ;
            dayScheduleRepository.save(day);
        }
        System.out.println("LLEGA ACAA");
//       
       
       
       
       ScheduleResponse reponse= scheduleMapper.toEntity(request, professional);
       return reponse;
    }


   
    
}
