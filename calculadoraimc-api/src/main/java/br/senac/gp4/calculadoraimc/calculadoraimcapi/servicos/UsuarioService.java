package br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> criarUsuario(Usuario usuario);

    Boolean verificaSeUsuarioExiste(String nomeUsuario);
}
