package br.com.nextgen.Services;

import br.com.nextgen.Entities.Operacao;
import br.com.nextgen.Repository.OperacaoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OperacaoService {

    private final OperacaoRepository operacaoRepository;
    // You shouldn't inject TalhaoRepository here unless you need it for a specific reason
    // private final TalhaoRepository talhaoRepository;

    public OperacaoService(OperacaoRepository operacaoRepository) {
        this.operacaoRepository = operacaoRepository;
    }

    public Operacao salvarOperacao(Operacao operacao) {
        // Correctly using operacaoRepository
        return operacaoRepository.save(operacao);
    }

    public Operacao buscarOperacaoId(Long id) {
        // Correctly using operacaoRepository
        return operacaoRepository.findById(id).orElse(null);
    }

    public List<Operacao> buscarTodosOperacao() {
        // Correctly using operacaoRepository
        return operacaoRepository.findAll();
    }

    public Operacao alterarOperacao(Long id, Operacao alteraOperacao) {
        Optional<Operacao> existeOperacao = operacaoRepository.findById(id);
        if (existeOperacao.isPresent()) {
            // Correctly using operacaoRepository
            return operacaoRepository.save(alteraOperacao);
        } else {
            return null;
        }
    }

    public Boolean deletarOperacao(Long id) {
        Optional<Operacao> existeOperacao = operacaoRepository.findById(id);
        if (existeOperacao.isPresent()) {
            // Correctly using operacaoRepository
            operacaoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}