package apifestivos.apifestivos.controladores;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import apifestivos.apifestivos.core.interfacesServicios.IFestivoServicio;
import apifestivos.apifestivos.entidades.Festivo;

@RestController
@RequestMapping("/festivos/verificar")

public class FestivoControlador {

    public IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio){

        this.servicio=servicio;
    }
    
    
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificarFestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        String fechaString = String.format("%d-%02d-%02d", año, mes, dia);
        if (servicio.esFechaValida(fechaString)) {
            LocalDate fecha = LocalDate.of(año, mes, dia);
            return servicio.esFestivo(fecha) ? "Es Festivo" : "No es festivo";
        } else {
            return "Fecha no válida";
        }
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/obtener/{año}")
    public List<Festivo> obtener(@PathVariable int año) {
        return (List<Festivo>) servicio.obtenerFestivos(año);
    }
}
