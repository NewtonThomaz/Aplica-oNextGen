package com.ProjetoSesi.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.nextgen.Entities.Talhao;
import br.com.nextgen.Services.TalhaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/talhaos")
public class TalhaoController {
    private final TalhaoService talhaoService;

    public TalhaoController(TalhaoService talhaoService) {
        this.talhaoService = talhaoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Talhao>> buscarTodosTalhaos(){
        List<Talhao> talhaos = talhaoService.buscarTodosTalhao();
        return ResponseEntity.ok(talhaos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talhao> buscarTalhaoPorId(@PathVariable Long id){
        Talhao talhao = talhaoService.buscarTalhaoId(id);
        if(talhao != null){
            return ResponseEntity.ok(talhao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<Talhao> salvarTalhao(@Valid @RequestBody Talhao talhao){
        Talhao criaTalhao = talhaoService.salvarTalhao(talhao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaTalhao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Talhao> alterarTalhao(@PathVariable Long id, @Valid @RequestBody Talhao talhao){
        Talhao alteraTalhao = talhaoService.alterarTalhao(id, talhao);
        if (alteraTalhao != null) {
            return ResponseEntity.ok(alteraTalhao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<String> desativarTalhao(@PathVariable Long id){
        Talhao talhao = talhaoService.buscarTalhaoId(id);
        if (talhao != null) {
            talhaoService.desativarTalhao(id);
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