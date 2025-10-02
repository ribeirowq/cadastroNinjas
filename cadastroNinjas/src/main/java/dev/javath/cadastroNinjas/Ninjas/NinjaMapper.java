package dev.javath.cadastroNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setCla(ninjaDTO.getCla());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setTecnicas(ninjaDTO.getTecnicas());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

        return ninjaModel;
    }

    public NinjaDTO map (NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setCla(ninjaModel.getCla());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setTecnicas(ninjaModel.getTecnicas());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

        return ninjaDTO;
    }
}
