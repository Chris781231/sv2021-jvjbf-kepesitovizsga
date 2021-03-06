package training360.guinessapp.recorder;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;
import training360.guinessapp.dto.RecorderShortDto;

import java.util.List;

@Service
@AllArgsConstructor
public class RecorderService {

    private ModelMapper modelMapper;

    private RecorderRepository repo;


    public RecorderDto save(RecorderCreateCommand command) {
        Recorder recorder = new Recorder(command.getName(), command.getDateOfBirth());
        Recorder savedRecorder = repo.save(recorder);
        return modelMapper.map(savedRecorder, RecorderDto.class);
    }

    public List<RecorderShortDto> findRecordersBy() {
        return repo.findRecorderByNameStartsWithOrNameContainsOrderByDateOfBirthDesc("B", "e");
    }
}
