package apifestivos.apifestivos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apifestivos.apifestivos.core.interfacesRepositorio.IFestivoRepositorio;
import apifestivos.apifestivos.core.interfacesServicios.IFestivoServicio;
import apifestivos.apifestivos.entidades.Festivo;

@Service
public class FestivoServicio implements IFestivoServicio {

    private IFestivoRepositorio repositorio;

    public FestivoServicio (IFestivoRepositorio repositorio)
    {
        this.repositorio = repositorio;
    }

    @Override
    public List<Festivo> listar() {
        
        return repositorio.findAll();
    }
    
}
