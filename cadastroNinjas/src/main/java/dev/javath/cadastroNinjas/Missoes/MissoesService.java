package dev.javath.cadastroNinjas.Missoes;

import dev.javath.cadastroNinjas.Ninjas.NinjaModel;
import dev.javath.cadastroNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;
    private NinjaRepository ninjaRepository;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper, NinjaRepository ninjaRepository) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
        this.ninjaRepository = ninjaRepository;
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missao = new MissoesMapper().map(missoesDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    public List<MissoesDTO> mostrarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO BuscarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::map).orElse(null);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.findById(id).ifPresent(missao -> {
            List<NinjaModel> ninjasVinculados = ninjaRepository.findByMissoes(missao);

            for (NinjaModel ninja : ninjasVinculados) {
                ninja.setMissoes(null);
                ninjaRepository.save(ninja);
            }

            missoesRepository.delete(missao);
        });
    }
}
