package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class InvalidWorldRecordException extends AbstractThrowableProblem {

    public InvalidWorldRecordException() {
        super(URI.create("guinessapp/can-not-beat"),
                "Can not beat",
                Status.BAD_REQUEST,
                "Can not beat");
    }
}
