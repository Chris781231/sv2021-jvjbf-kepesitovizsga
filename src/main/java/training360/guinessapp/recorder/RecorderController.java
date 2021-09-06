package training360.guinessapp.recorder;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/recorders")
@AllArgsConstructor
public class RecorderController {

    private RecorderService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecorderDto save(@RequestBody @Valid RecorderCreateCommand command) {
        return service.save(command);
    }
}
