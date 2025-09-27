package dev.javath.cadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> mostrarTodosOsNinjas(){
       return ninjaRepository.findAll();
    }

    public Optional<NinjaModel> mostrarNinjaPorId(Long id) {
        return ninjaRepository.findById(id);
    }
    public NinjaModel atualizarNinjaPorId(Long id, NinjaModel ninjaAtualizado){
        if (ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        } else {
            return null;
        }
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }


}
