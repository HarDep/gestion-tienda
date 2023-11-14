package co.edu.uptc.repositories;

import co.edu.uptc.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.time.LocalDateTime;

@DataJpaTest
@Rollback
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseTest {
    @Autowired
    private LoteRepository loteRepository;
    @Autowired
    private SujetoRepository sujetoRepository;
    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private VentaRepository ventaRepository;

    @Test
    void testConstraintsPrimarios(){
        Lote lote = Lote.builder().fechaLote(LocalDate.of(2023,2,3)).build();
        Lote loteSaved = loteRepository.save(lote);
        Lote lote1 = loteRepository.findById(loteSaved.getId()).orElse(null);

        Assertions.assertNotNull(lote1);
        Assertions.assertTrue(lote1.getId() > 0);

        Sujeto sujeto = Sujeto.builder().nombre("pruebaSujeto").telefono("737377")
                .tipoSujeto(TipoSujeto.PER).apellido("prueba").numeroDocumento("171771").build();
        Sujeto sujetoSaved = sujetoRepository.save(sujeto);
        Sujeto sujeto1 = sujetoRepository.findById(sujetoSaved.getId()).orElse(null);

        Assertions.assertNotNull(sujeto1);
        Assertions.assertTrue(sujeto1.getId() > 0);
        Assertions.assertEquals("pruebaSujeto", sujeto1.getNombre());
        Assertions.assertEquals("171771", sujeto1.getNumeroDocumento());

        CategoriaProducto categoriaProducto = CategoriaProducto.builder().nombre("catPrueba").build();
        CategoriaProducto categoriaSaved = categoriaProductoRepository.save(categoriaProducto);
        CategoriaProducto categoriaProducto1 = categoriaProductoRepository.findById(categoriaSaved.getId())
                .orElse(null);

        Assertions.assertNotNull(categoriaProducto1);
        Assertions.assertTrue(categoriaProducto1.getId() > 0);
        Assertions.assertEquals("catPrueba", categoriaProducto1.getNombre());
    }

    @Test
    void testConstraintsCheck(){
        // la fecha no puede ser mayor que la actual
        Compra compra = Compra.builder().lote(Lote.builder().id(1).build()).proveedor(
                Sujeto.builder().id(3).build()).fecha(LocalDateTime.of(2024,1,1,
                0,0)).build();

        Assertions.assertThrows(DataIntegrityViolationException.class,() ->
                compraRepository.save(compra));

        Venta venta = Venta.builder().cliente(Sujeto.builder().id(2).build())
                .empleado(Sujeto.builder().id(6).build()).fechaVenta(LocalDateTime.of(2023,1,1,
                        0,0)).precioEntrega(-13.4).build();
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> ventaRepository.save(venta));
    }

    @Test
    void testConstraintsUnique(){
        //el telefono es único, el telefono utilizado ya existe
        Sujeto sujeto = Sujeto.builder().nombre("pruebaSujeto").telefono("3167577757")
                .tipoSujeto(TipoSujeto.PER).apellido("prueba").numeroDocumento("171771").build();

        Assertions.assertThrows(DataIntegrityViolationException.class,() -> sujetoRepository.save(sujeto));

        //el número doc es único, el doc utilizado ya existe
        Sujeto sujeto2 = Sujeto.builder().nombre("pruebaSujeto").telefono("78484866")
                .tipoSujeto(TipoSujeto.PER).apellido("prueba").numeroDocumento("123631").build();

        Assertions.assertThrows(DataIntegrityViolationException.class,() -> sujetoRepository.save(sujeto2));

        //el nit es único, el nit utilizado ya existe
        Sujeto sujeto3 = Sujeto.builder().nombre("pruebaSujeto").telefono("78484866")
                .tipoSujeto(TipoSujeto.EMP).nit("NIT1212").build();

        Assertions.assertThrows(DataIntegrityViolationException.class,() -> sujetoRepository.save(sujeto3));
    }
}
