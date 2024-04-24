package apifestivos.apifestivos.core.interfacesServicios;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import apifestivos.apifestivos.entidades.Festivo;

@Service
public interface IFestivoServicio {

    public boolean esFestivo(Date Fecha);
    public boolean esFechaValida(String strFecha);
    public List<Festivo> obtenerFestivos(int año);
} 