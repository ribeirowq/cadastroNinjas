package dev.javath.cadastroNinjas.Ninjas;

import dev.javath.cadastroNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String cla;
    private String rank;
    private String tecnicas;
    private MissoesModel missoes;
}
