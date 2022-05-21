package br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.impl;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Usuario;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.repositorios.UsuarioRepository;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> criarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByNome(usuario.getNome().toLowerCase())) {
            throw new IllegalArgumentException("Já existe um usuário com este nome!");
        }
        usuario.setNome(usuario.getNome().toLowerCase());
        return Optional.ofNullable(usuarioRepository.save(usuario));
    }

    @Override
    public Boolean verificaSeUsuarioExiste(String nomeUsuario) {
        return usuarioRepository.existsByNome(nomeUsuario.toLowerCase());
    }
}
