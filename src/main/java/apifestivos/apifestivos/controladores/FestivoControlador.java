package apifestivos.apifestivos.controladores;


import java.util.List;

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
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }
}
