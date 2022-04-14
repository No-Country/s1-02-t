
package consultation.by.video.call.model.request;

import consultation.by.video.call.model.entity.DaySchedule;
import consultation.by.video.call.model.entity.Professional;
import consultation.by.video.call.model.enums.EnumState;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder @Getter @Setter
public class ScheduleRequest {
    
    private Professional professional;
    private List<DaySchedule> daySchedule;
   
    @Enumerated(value = EnumType.STRING)
    private EnumState status;
}
