package consultation.by.video.call.repository;

import consultation.by.video.call.model.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepositoy extends JpaRepository<Profession, Long> {

}
