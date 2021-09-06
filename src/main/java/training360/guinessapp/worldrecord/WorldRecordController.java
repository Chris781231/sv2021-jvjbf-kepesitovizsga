package training360.guinessapp.worldrecord;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.*;
import training360.guinessapp.recorder.RecorderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/worldrecords")
@AllArgsConstructor
public class WorldRecordController {

    private WorldRecordService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto save(@RequestBody @Valid WorldRecordCreateCommand command) {
        return service.save(command);
    }

    @PutMapping("/{id}/beatrecords")
    public BeatWorldRecordDto beatWorldRecord(@PathVariable("id") long worldRecordId, @RequestBody @Valid BeatWorldRecordCommand command) {
        return service.beatWorldRecord(worldRecordId, command);
    }
}
