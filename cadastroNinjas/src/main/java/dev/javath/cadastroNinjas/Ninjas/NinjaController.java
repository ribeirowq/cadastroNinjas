package dev.javath.cadastroNinjas.Ninjas;

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
        return "Boas Vindas ao meu site";
    }

    @PostMapping("/criar")
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/todos")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodosOsNinjas();
    }

    @GetMapping("/mostrar/{id}")
    public Optional<NinjaModel> mostrarNinjaPorId(@PathVariable Long id){
        return ninjaService.mostrarNinjaPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarNinjaPorId(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinjaPorId(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}
