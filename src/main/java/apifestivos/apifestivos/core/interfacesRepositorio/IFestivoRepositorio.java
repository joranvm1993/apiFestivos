package apifestivos.apifestivos.core.interfacesRepositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import apifestivos.apifestivos.entidades.Festivo;

/**
 * IFestivoRespositorio
 */
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {

    
}