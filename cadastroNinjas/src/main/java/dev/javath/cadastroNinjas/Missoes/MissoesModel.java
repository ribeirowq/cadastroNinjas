package dev.javath.cadastroNinjas.Missoes;

import dev.javath.cadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;

    // @OneToMany - Uma missao para muitos ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;
 

}
