package dev.javath.cadastroNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel model = new MissoesModel();
        model.setId(missoesDTO.getId());
        model.setNome(missoesDTO.getNome());
        model.setRank(missoesDTO.getRank());
        model.setNivel(missoesDTO.getNivel());
        model.setNinjas(missoesDTO.getNinjas());
        return model;
    }

    public MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO dto = new MissoesDTO();
        dto.setId(missoesModel.getId());
        dto.setNome(missoesModel.getNome());
        dto.setRank(missoesModel.getRank());
        dto.setNivel(missoesModel.getNivel());
        dto.setNinjas(missoesModel.getNinjas());
        return dto;
    }
}
