package co.edu.uptc.entities;

import lombok.Getter;

@Getter
public enum TipoSujeto {
    PER("Persona"),EMP("Empresa"),MEE("OWNER");

    private final String value;

    TipoSujeto(String value){
        this.value = value;
    }
}
