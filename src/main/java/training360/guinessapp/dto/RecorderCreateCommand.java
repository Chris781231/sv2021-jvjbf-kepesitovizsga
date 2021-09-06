package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.IsValidDate;
import training360.guinessapp.ValidString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecorderCreateCommand {

    @ValidString
    private String name;

    @NotNull
    @IsValidDate
    private LocalDate dateOfBirth;
}
