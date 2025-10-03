package dev.javath.cadastroNinjas.Missoes;


import dev.javath.cadastroNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nome;
    private String rank;
    private String nivel;
    private List<NinjaModel> ninjas;
}
