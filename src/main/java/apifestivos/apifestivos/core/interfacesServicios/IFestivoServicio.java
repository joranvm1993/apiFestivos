package apifestivos.apifestivos.core.interfacesServicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apifestivos.apifestivos.entidades.Festivo;

@Service
public interface IFestivoServicio {

    public List<Festivo> listar();
} 