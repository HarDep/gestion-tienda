package co.edu.uptc.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter @Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException{

    private String resourceName;

    private String fieldName;

    private String valueField;

    public ResourceNotFound(String resourceName, String fieldName, String valueField) {
        super(String.format("%s no encontrado: campo %s, valor '%s'",
                resourceName, fieldName, valueField));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.valueField = valueField;
    }
}
