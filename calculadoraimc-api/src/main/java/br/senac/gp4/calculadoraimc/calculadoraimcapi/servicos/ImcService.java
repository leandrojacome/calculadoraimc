package br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.dto.ImcDto;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Imc;

import java.util.List;

public interface ImcService {

    Imc calculaImcESalva(Long usuarioId, ImcDto imcDto);

    List<Imc> pegarTodos(Long idUsuario);
}
