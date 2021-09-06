package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EntityNotFoundException extends AbstractThrowableProblem {

    public EntityNotFoundException(long id, String entity) {
        super(URI.create("guinessapp/" + entity + "-not-found"),
                entity + " not found",
                Status.NOT_FOUND,
                String.format(entity + " with id %d not found", id));
    }
}
