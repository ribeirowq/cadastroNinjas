package dev.javath.cadastroNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Boas vindas ao meu site";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome());
    }

    @GetMapping("/todos")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodosOsNinjas();
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id){

        if (ninjaService.mostrarNinjaPorId(id) != null) {
             NinjaDTO ninja = ninjaService.mostrarNinjaPorId(id);
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o ID: " + id + " não existe.");
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){

        if (ninjaService.mostrarNinjaPorId(id) != null) {
            NinjaDTO ninja = ninjaService.atualizarNinjaPorId(id, ninjaDTO);
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não existe.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){

       if (ninjaService.mostrarNinjaPorId(id) != null) {
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok()
                   .body("Ninja foi deletado com sucesso");
       }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Ninja com ID: " + id + " não existe.");
       }


    }
}
