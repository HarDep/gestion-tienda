package co.edu.uptc.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter @Setter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidResource extends RuntimeException{

    private String resourceName;

    private String reason;

    private String valueField;

    public InvalidResource(String resourceName, String reason, String valueField) {
        super(String.format("%s con el valor %s no aceptado ya que %s",
                resourceName, valueField, reason));
        this.resourceName = resourceName;
        this.reason = reason;
        this.valueField = valueField;
    }
}
