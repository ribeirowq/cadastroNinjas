package dev.javath.cadastroNinjas.Missoes;

import dev.javath.cadastroNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("missão criada com sucesso: " + novaMissao.getNome());
    }

    @GetMapping("/mostrar")
    public List<MissoesDTO> mostrarMissoes() {
        return missoesService.mostrarMissoes();
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarMissoesPorId(@PathVariable Long id){

        if (missoesService.BuscarMissaoPorId(id) != null) {
            MissoesDTO missao = missoesService.BuscarMissaoPorId(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(missao);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não existe");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id){
        if (missoesService.BuscarMissaoPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok()
                    .body("Missao deletada!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não existe");
        }

    }
}
