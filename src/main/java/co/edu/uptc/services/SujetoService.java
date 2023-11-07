package co.edu.uptc.services;

import co.edu.uptc.models.Sujeto;

import java.util.List;

public interface SujetoService {
    List<Sujeto> getAll();
    List<Sujeto> getEmployees();
}
