package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.EntityNotFoundException;
import training360.guinessapp.InvalidWorldRecordException;
import training360.guinessapp.dto.*;
import training360.guinessapp.recorder.Recorder;
import training360.guinessapp.recorder.RecorderRepository;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WorldRecordService {

    private ModelMapper modelMapper;

    private WorldRecordRepository worldRecordRepo;

    private RecorderRepository recorderRepo;

    public WorldRecordDto save(WorldRecordCreateCommand command) {
        Recorder recorder = recorderRepo.findById(command.getRecorderId())
                .orElseThrow(() -> new EntityNotFoundException(command.getRecorderId(), "Recorder"));
        WorldRecord worldRecord = new WorldRecord(command.getDescription(), command.getValue(), command.getUnitOfMeasure(), command.getDate(), recorder);
        WorldRecord savedWorldRecord = worldRecordRepo.save(worldRecord);
        return modelMapper.map(savedWorldRecord, WorldRecordDto.class);
    }

    @Transactional
    public BeatWorldRecordDto beatWorldRecord(long worldRecordId, BeatWorldRecordCommand command) {
        WorldRecord worldRecord = worldRecordRepo.findById(worldRecordId)
                .orElseThrow(() -> new EntityNotFoundException(command.getRecorderId(), "World-record"));
        Recorder oldRecorder = worldRecord.getRecorder();
        Recorder newRecorder = recorderRepo.findById(command.getRecorderId())
                .orElseThrow(() -> new EntityNotFoundException(command.getRecorderId(), "Recorder"));
        Double oldRecordValue = worldRecord.getValue();
        Double newRecordValue = command.getValue();
        Double recordDifference = newRecordValue - oldRecordValue;
        if (recordDifference < 0) {
            throw new InvalidWorldRecordException();
        }

        worldRecord.setValue(newRecordValue);
        worldRecord.setRecorder(newRecorder);
        worldRecord.setDateOfRecord(LocalDate.now());

        return new BeatWorldRecordDto(worldRecord.getDescription(), worldRecord.getUnitOfMeasure(), oldRecorder.getName(), newRecorder.getName(), newRecordValue, recordDifference);
    }
}
