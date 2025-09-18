package br.com.nextgen.Services;

import br.com.nextgen.Entities.Umidade;
import br.com.nextgen.Repository.UmidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UmidadeService {
    private final UmidadeRepository umidadeRepository;

    public UmidadeService(UmidadeRepository umidadeRepository) {
        this.umidadeRepository = umidadeRepository;
    }

    public Umidade salvarUmidade(Umidade umidade) {
        return umidadeRepository.save(umidade);
    }

    public Umidade buscarUmidadeId(Long id) {
        return umidadeRepository.findById(id).orElse(null);
    }

    public List<Umidade> buscarTodasUmidades() {
        return umidadeRepository.findAll();
    }

    public Umidade alterarUmidade(Long id, Umidade alteraUmidade) {
        Optional<Umidade> existeUmidade = umidadeRepository.findById(id);
        if (existeUmidade.isPresent()) {
            return umidadeRepository.save(alteraUmidade);
        } else {
            return null;
        }
    }

    public Boolean deletarUmidade(Long id) {
        Optional<Umidade> existeUmidade = umidadeRepository.findById(id);
        if (existeUmidade.isPresent()) {
            umidadeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}