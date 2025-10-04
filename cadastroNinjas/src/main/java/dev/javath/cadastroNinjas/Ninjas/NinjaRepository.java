package dev.javath.cadastroNinjas.Ninjas;

import dev.javath.cadastroNinjas.Missoes.MissoesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
    List<NinjaModel> findByMissoes(MissoesModel missoes);
}
