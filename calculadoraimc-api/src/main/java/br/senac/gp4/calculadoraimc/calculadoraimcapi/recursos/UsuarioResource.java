package br.senac.gp4.calculadoraimc.calculadoraimcapi.recursos;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Usuario;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioResource {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario).map(ResponseEntity::ok)
                .orElseThrow(() -> new IllegalArgumentException("Já existe um usuário com este nome!"));
    }

    @GetMapping("/{nomeUsuario}")
    public ResponseEntity<Boolean> verificaSeUsuarioExiste(@PathVariable String nomeUsuario) {
        return ResponseEntity.ok(usuarioService.verificaSeUsuarioExiste(nomeUsuario));
    }

}
