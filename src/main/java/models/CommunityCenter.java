package models;

import lombok.*;
import models.enums.RecursoTipo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.EnumMap;
import java.util.Map;

@Document(collection = "centros_comunitarios")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CentroComunitario {

    @Id
    private String id;

    private String nome;
    private String endereco;
    private double latitude;
    private double longitude;

    private int capacidadeMaxima;
    private int ocupacaoAtual;

    private Map<RecursoTipo, Integer> recursos = new EnumMap<>(RecursoTipo.class);
}
