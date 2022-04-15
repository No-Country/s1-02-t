
package consultation.by.video.call.model.mapper;

import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.entity.Schedule;
import consultation.by.video.call.model.enums.EnumState;
import consultation.by.video.call.model.request.ScheduleRequest;
import consultation.by.video.call.model.response.ScheduleResponse;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {
    public ScheduleResponse toEntity(ScheduleRequest request, Professional professional){
        return ScheduleResponse.builder()
                .id_professional(professional.getId())
                .firstName(professional.getFirstName())
                .lastName(professional.getLastName())
//                .daySchedule(request.getDaySchedule())                
                .build();
    }
//   public Schedule toEntity(ScheduleRequest request){
//        return Schedule.builder()
//               .day(request.getDay())
//                .hours(request.getHours())
//                .status(EnumState.ACTIVED)
////                .daySchedule(request.getDaySchedule())                
//                .build();
//    }
}
