package training360.guinessapp.recorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

public interface RecorderRepository extends JpaRepository<Recorder, Long> {


    List<RecorderShortDto> findRecorderByNameStartsWithOrNameContainsOrderByDateOfBirthDesc(String startsWith, String contains);
}
