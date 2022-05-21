package br.senac.gp4.calculadoraimc.calculadoraimcapi.recursos;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.dto.ImcDto;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Imc;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.ImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imc")
@RequiredArgsConstructor
@Slf4j
public class ImcResource {

    private final ImcService imcService;

    @PostMapping("/{usuarioId}")
    public ResponseEntity<Double> calculaImcESalva(@PathVariable Long usuarioId, @RequestBody ImcDto imcDto) {
        return ResponseEntity.ok(imcService.calculaImcESalva(usuarioId, imcDto));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<Imc>> pegarTodos(@PathVariable Long idUsuario) {
        log.info("Requisitado todos os IMCs do usuario {}", idUsuario);
        return ResponseEntity.ok(imcService.pegarTodos(idUsuario));
    }

}
