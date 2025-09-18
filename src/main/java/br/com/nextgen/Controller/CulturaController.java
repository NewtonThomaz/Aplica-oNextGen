package br.com.nextgen.Controller;

import br.com.nextgen.Entities.Cultura;
import br.com.nextgen.Services.CulturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/culturas")
public class CulturaController {
    private final CulturaService culturaService;

    public CulturaController(CulturaService culturaService) {
        this.culturaService = culturaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Cultura>> buscarTodasCulturas(){
        List<Cultura> culturas = culturaService.buscarTodosCultura();
        return ResponseEntity.ok(culturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cultura> buscarCulturaId(@PathVariable Long id){
        Cultura cultura = culturaService.buscarCulturaId(id);
        if (cultura != null) {
            return ResponseEntity.ok(cultura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Cultura> salvarCultura(@Valid @RequestBody Cultura cultura){
        Cultura criaCultura = culturaService.salvarCultura(cultura);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaCultura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cultura> alterarCultura(@PathVariable Long id, @Valid @RequestBody Cultura cultura){
        Cultura alteraCultura = culturaService.alterarCultura(id, cultura);
        if (alteraCultura != null) {
            return ResponseEntity.ok(alteraCultura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCultura(@PathVariable Long id){
        boolean deletado = culturaService.deletarCultura(id);
        if (deletado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
