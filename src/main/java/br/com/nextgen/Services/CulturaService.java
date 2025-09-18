package br.com.nextgen.Services;

import br.com.nextgen.Entities.Cultura;
import br.com.nextgen.Repository.CulturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CulturaService {
    private final CulturaRepository culturaRepository;

    public CulturaService(CulturaRepository culturaRepository) {
        this.culturaRepository = culturaRepository;
    }

    public Cultura salvarCultura(Cultura cultura) {
        return culturaRepository.save(cultura);
    }

    public Cultura buscarCulturaId(Long id) {
        return culturaRepository.findById(id).orElse(null);
    }

    public List<Cultura> buscarTodosCultura() {
        return culturaRepository.findAll();
    }

    public Cultura alterarCultura(Long id, Cultura alteraCultura) {
        Optional<Cultura> existeCultura = culturaRepository.findById(id);
        if (existeCultura.isPresent()) {
            return culturaRepository.save(alteraCultura);
        } else {
            return null;
        }
    }

    public Boolean deletarCultura(Long id) {
        Optional<Cultura> existeCultura = culturaRepository.findById(id);
        if (existeCultura.isPresent()) {
            culturaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
