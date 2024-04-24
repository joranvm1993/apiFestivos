package apifestivos.apifestivos.servicios;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
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
    private Date obtenerDomingoPascua(int año) {
        int a = año % 19;
        int b = año / 100;
        int c = año % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int mes = (h + l - 7 * m + 114) / 31;
        int dia = ((h + l - 7 * m + 114) % 31) + 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes - 1, dia);
        return (Date) calendar.getTime();
    }

    private LocalDate siguienteLunes(LocalDate fecha) {
        return fecha.with(DayOfWeek.MONDAY);
    }

    private LocalDate agregarDias(LocalDate fecha, int dias) {
        return fecha.plusDays(dias);
    }
    private List<Festivo> calcularFestivos(List<Festivo> festivos, int año) {
        if (festivos != null) {
            Date pascua = obtenerDomingoPascua(año);
            for (Festivo festivo : festivos) {
                switch (festivos.getTipoFestivo().getId()) {
                    case 1:
                        festivos.setFecha(LocalDate.of(año, festivo.getMes(), festivo.getDia()));
                        break;
                    case 2:
                        festivos.setFecha(siguienteLunes(LocalDate.of(año, festivo.getMes(), festivo.getDia())));
                        break;
                    case 3:
                        festivos.setFecha(pascua.plusDays(festivo.getDiasPascua()));
                        break;
                    case 4:
                        festivos.setFecha(siguienteLunes(pascua.plusDays(festivo.getDiasPascua())));
                        break;
                }
            }
        }
        return festivos;
    }


    @Override
    public List<Festivo> listar() {
        
        return repositorio.findAll();
    }

    @Override
    public boolean esFestivo(Date Fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esFestivo'");
    }

    @Override
    public boolean esFechaValida(String strFecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esFechaValida'");
    }
    
}
