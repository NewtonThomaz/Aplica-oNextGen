package br.com.nextgen.Controller;

import br.com.nextgen.Entities.Colaborador;
import br.com.nextgen.Services.ColaboradorService;
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
@RequestMapping("/colaboradores")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Colaborador>> buscarTodosColaboradores(){
        List<Colaborador> colaboradores = colaboradorService.buscarTodosColaborador();
        return ResponseEntity.ok(colaboradores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarColaboradorId(@PathVariable Long id){
        Colaborador colaborador = colaboradorService.buscarColaboradorId(id);
        if (colaborador != null) {
            return ResponseEntity.ok(colaborador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Colaborador> salvarColaborador(@Valid @RequestBody Colaborador colaborador){
        Colaborador criaColaborador = colaboradorService.salvarColaborador(colaborador);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaColaborador);
    }

    //trocar put por patch
    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> alterarColaborador(@PathVariable Long id, @Valid @RequestBody Colaborador colaborador){
        Colaborador alteraColaborador = colaboradorService.alterarColaborador(id, colaborador);
        if (alteraColaborador != null) {
            return ResponseEntity.ok(alteraColaborador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarColaborador(@PathVariable Long id){
        boolean deletado = colaboradorService.deletarColaborador(id);
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
