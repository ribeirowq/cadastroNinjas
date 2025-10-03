package dev.javath.cadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        System.out.println("DTO Recebido: " + ninjaDTO.getNome() + ", " + ninjaDTO.getCla());
        NinjaModel ninja = new NinjaMapper().map(ninjaDTO);
        System.out.println("Model Antes do Save: " + ninja.getNome() + ", " + ninja.getCla());
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public List<NinjaDTO> mostrarTodosOsNinjas(){
       List<NinjaModel> ninjas = ninjaRepository.findAll();
       return ninjas.stream()
               .map(ninjaMapper::map)
               .collect(Collectors.toList());
    }

    public NinjaDTO mostrarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaEncontrado = ninjaRepository.findById(id);
        if (ninjaEncontrado.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo =  ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }


}
