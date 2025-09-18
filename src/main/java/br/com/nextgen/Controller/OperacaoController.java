package br.com.nextgen.Controller;


import br.com.nextgen.Entities.Operacao;
import br.com.nextgen.Services.OperacaoService;
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
@RequestMapping("/operacoes")
public class OperacaoController {
    private final OperacaoService operacaoService;

    public OperacaoController(OperacaoService operacaoService) {
        this.operacaoService = operacaoService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Operacao>> buscarTodasOperacoes(){
        List<Operacao> operacoes = operacaoService.buscarTodosOperacao();
        return ResponseEntity.ok(operacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operacao> buscarOperacaoId(@PathVariable Long id){
        Operacao operacao = operacaoService.buscarOperacaoId(id);
        if (operacao != null) {
            return ResponseEntity.ok(operacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Operacao> salvarOperacao(@Valid @RequestBody Operacao operacao){
        Operacao criaOperacao = operacaoService.salvarOperacao(operacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criaOperacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Operacao> alterarOperacao(@PathVariable Long id, @Valid @RequestBody Operacao operacao){
        Operacao alteraOperacao = operacaoService.alterarOperacao(id, operacao);
        if (alteraOperacao != null) {
            return ResponseEntity.ok(alteraOperacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarOperacao(@PathVariable Long id){
        boolean deletado = operacaoService.deletarOperacao(id);
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
