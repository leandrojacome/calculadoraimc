package br.senac.gp4.calculadoraimc.calculadoraimcapi.config.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ResponseError {

    private Integer httpStatus;
    private String description;
    private Map<String, String> fields;

}
