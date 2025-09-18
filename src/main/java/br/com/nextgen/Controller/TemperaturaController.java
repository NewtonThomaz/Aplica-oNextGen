package br.com.nextgen.Controller;

import br.com.nextgen.Entities.Temperatura;
import br.com.nextgen.Services.TemperaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/temperaturas")
public class TemperaturaController {
    private final TemperaturaService temperaturaService;

    public TemperaturaController(TemperaturaService temperaturaService) {
        this.temperaturaService = temperaturaService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Temperatura>> buscarTodasTemperaturas(){
        List<Temperatura> temperaturas = temperaturaService.buscarTodasTemperatura();
        return ResponseEntity.ok(temperaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Temperatura> buscarTemperaturaId(@PathVariable Long id){
        Temperatura temperatura = temperaturaService.buscarTemperaturaId(id);
        if (temperatura != null) {
            return ResponseEntity.ok(temperatura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Temperatura> salvarTemperatura(@Valid @RequestBody Temperatura temperatura){
        Temperatura criaTemperatura = temperaturaService.salvarTemperatura(temperatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaTemperatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Temperatura> alterarTemperatura(@PathVariable Long id, @Valid @RequestBody Temperatura temperatura){
        Temperatura alteraTemperatura = temperaturaService.alterarTemperatura(id, temperatura);
        if (alteraTemperatura != null) {
            return ResponseEntity.ok(alteraTemperatura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTemperatura(@PathVariable Long id){
        boolean deletado = temperaturaService.deletarTemperatura(id);
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
