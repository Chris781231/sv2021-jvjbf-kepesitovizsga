package training360.guinessapp;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class EntityNotFoundException extends AbstractThrowableProblem {

    public EntityNotFoundException(long id, String uriName, String name) {
        super(URI.create("guinessapp/" + uriName + "-not-found"),
                name + " not found",
                Status.NOT_FOUND,
                String.format(name + " with id %d not found", id));
    }
}
