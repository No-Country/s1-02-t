package consultation.by.video.call.repository;

import consultation.by.video.call.model.entity.Schedule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
      List<Schedule> findByProfessional(Long id);

}
