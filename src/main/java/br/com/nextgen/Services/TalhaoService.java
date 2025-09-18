package br.com.nextgen.Services;

import br.com.nextgen.Entities.Talhao;
import br.com.nextgen.Repository.TalhaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalhaoService {

    private final TalhaoRepository talhaoRepository;

    public TalhaoService(TalhaoRepository talhaoRepository) {
        this.talhaoRepository = talhaoRepository;
    }

    public Talhao salvarTalhao(Talhao talhao) {
        return talhaoRepository.save(talhao);
    }

    public Talhao buscarTalhaoId(Long id) {
        return talhaoRepository.findById(id).orElse(null);
    }

    public List<Talhao> buscarTodosTalhao() {
        return talhaoRepository.findAll();
    }

    public Talhao alterarTalhao(Long id, Talhao alteraTalhao) {
        Optional<Talhao> existeTalhao = talhaoRepository.findById(id);
        if (existeTalhao.isPresent()) {
            return talhaoRepository.save(alteraTalhao);
        } else {
            return null;
        }
    }

    // Campo sem excluir a merda do talhao
    public void desativarTalhao(Long id) {
        talhaoRepository.deleteById(id);
    }
}