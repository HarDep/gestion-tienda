package co.edu.uptc.services;

import co.edu.uptc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository compraRepository;
}
