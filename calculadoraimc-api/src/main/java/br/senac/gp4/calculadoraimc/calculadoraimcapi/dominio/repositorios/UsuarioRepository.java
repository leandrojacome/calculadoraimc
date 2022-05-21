package br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.repositorios;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Boolean existsByNome(String nome);

}
