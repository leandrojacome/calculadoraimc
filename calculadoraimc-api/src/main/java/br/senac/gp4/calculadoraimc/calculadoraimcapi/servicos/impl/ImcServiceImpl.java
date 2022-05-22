package br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.impl;

import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.dto.ImcDto;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Imc;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades.Usuario;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.repositorios.ImcRepository;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.repositorios.UsuarioRepository;
import br.senac.gp4.calculadoraimc.calculadoraimcapi.servicos.ImcService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImcServiceImpl implements ImcService {

    private final ImcRepository imcRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Imc calculaImcESalva(Long usuarioId, ImcDto imcDto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
        Imc imc = new Imc();
        imc.setAltura(imcDto.getAltura());
        imc.setPeso(imcDto.getPeso());
        log.info(String.valueOf(Math.pow(imcDto.getAltura(), 2)));
        Double imcCalculado = imcDto.getPeso() / Math.pow(imcDto.getAltura(), 2);
        imc.setImc(imcCalculado);
        imc.setUsuario(usuario);
        imc.setData(LocalDateTime.now());
        Imc imcSalvo = imcRepository.save(imc);
        return imcSalvo;
    }

    @Override
    public List<Imc> pegarTodos(Long idUsuario) {
        return imcRepository.findAllByUsuario_Id(idUsuario);
    }
}
