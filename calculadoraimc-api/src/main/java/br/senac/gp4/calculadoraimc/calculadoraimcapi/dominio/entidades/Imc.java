package br.senac.gp4.calculadoraimc.calculadoraimcapi.dominio.entidades;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Imc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double altura;
    private Double peso;
    private Double imc;
    @ManyToOne
    private Usuario usuario;
    private LocalDateTime data;
}
