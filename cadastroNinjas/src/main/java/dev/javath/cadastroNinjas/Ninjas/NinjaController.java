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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/todos")
    public List<NinjaDTO> mostrarTodosOsNinjas(){
        return ninjaService.mostrarTodosOsNinjas();
    }

    @GetMapping("/mostrar/{id}")
    public NinjaDTO mostrarNinjaPorId(@PathVariable Long id){
        return ninjaService.mostrarNinjaPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO){
        return ninjaService.atualizarNinjaPorId(id, ninjaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}
