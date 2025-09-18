package br.com.nextgen.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.nextgen.Entities.Umidade;
import br.com.nextgen.Services.UmidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/umidades")
public class UmidadeController {
    private final UmidadeService umidadeService;

    public UmidadeController(UmidadeService umidadeService) {
        this.umidadeService = umidadeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Umidade>> buscarTodasUmidades(){
        List<Umidade> umidades = umidadeService.buscarTodasUmidades();
        return ResponseEntity.ok(umidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Umidade> buscarUmidadeId(@PathVariable Long id){
        Umidade umidade = umidadeService.buscarUmidadeId(id);
        if (umidade != null) {
            return ResponseEntity.ok(umidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Umidade> salvarUmidade(@Valid @RequestBody Umidade umidade){
        Umidade criaUmidade = umidadeService.salvarUmidade(umidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaUmidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Umidade> alterarUmidade(@PathVariable Long id, @Valid @RequestBody Umidade umidade){
        Umidade alteraUmidade = umidadeService.alterarUmidade(id, umidade);
        if (alteraUmidade != null) {
            return ResponseEntity.ok(alteraUmidade);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUmidade(@PathVariable Long id){
        boolean deletado = umidadeService.deletarUmidade(id);
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
