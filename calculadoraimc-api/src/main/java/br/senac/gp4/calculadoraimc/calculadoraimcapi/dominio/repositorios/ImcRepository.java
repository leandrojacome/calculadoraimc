package br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.repositorios;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Imc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImcRepository extends JpaRepository<Imc, Long> {

    List<Imc> findAllByUsuario_Id(Long idUsuario);

}
