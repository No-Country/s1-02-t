
package consultation.by.video.call.model.response;

import consultation.by.video.call.model.entity.Schedule;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ScheduleUserResponse {
    
    private Long id_professional;
    private String firstName;
    private String lastName;
    
    private Long id_schedule; 
    private List<Schedule> daySchedule;
    
}
