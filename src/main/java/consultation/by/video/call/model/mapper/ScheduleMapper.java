
package consultation.by.video.call.model.mapper;

import consultation.by.video.call.model.entity.DaySchedule;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Schedule;
import consultation.by.video.call.model.request.ScheduleRequest;
import consultation.by.video.call.model.response.ScheduleResponse;
import consultation.by.video.call.model.response.ScheduleUserResponse;
import consultation.by.video.call.repository.ScheduleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
 
    @Autowired 
    private ScheduleRepository  scheduleRepository;
    
    public ScheduleResponse toEntity(ScheduleRequest request, Professional professional){
        return ScheduleResponse.builder()
                .id_professional(professional.getId())
                .firstName(professional.getFirstName())
                .lastName(professional.getLastName())
//                .daySchedule(request.getDaySchedule())                
                .build();
    }
   public Schedule toEntitySchedule(ScheduleRequest request, Professional professional, List<DaySchedule> daySchedule){
        return Schedule.builder()
              .dayMonthYear(request.getDay())
              .professional(professional)
              .homeWork(daySchedule)    
                .build();
    }
   public ScheduleUserResponse  UsertoEntitySchedule(Professional professional){
       return ScheduleUserResponse.builder()
               .id_professional(professional.getId())
               .firstName(professional.getFirstName())
               .lastName(professional.getLastName())
                .daySchedule(professional.getSchedule())
               .build();
   }
}
