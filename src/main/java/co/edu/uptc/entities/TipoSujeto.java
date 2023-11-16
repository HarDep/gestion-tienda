package co.edu.uptc.entities;

import lombok.Getter;

@Getter
public enum TipoSujeto {
    PER("Persona"),EMP("Empleado"),MEE("OWN");

    private final String value;

    TipoSujeto(String value){
        this.value = value;
    }
}
