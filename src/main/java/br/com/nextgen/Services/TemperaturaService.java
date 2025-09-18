package br.com.nextgen.Services;

import br.com.nextgen.Entities.Temperatura;
import br.com.nextgen.Repository.TemperaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemperaturaService {
    private final TemperaturaRepository temperaturaRepository;

    public TemperaturaService(TemperaturaRepository temperaturaRepository) {
        this.temperaturaRepository = temperaturaRepository;
    }

    public Temperatura salvarTemperatura(Temperatura temperatura) {
        return temperaturaRepository.save(temperatura);
    }

    public Temperatura buscarTemperaturaId(Long id) {
        return temperaturaRepository.findById(id).orElse(null);
    }

    public List<Temperatura> buscarTodasTemperatura() {
        return temperaturaRepository.findAll();
    }

    public Temperatura alterarTemperatura(Long id, Temperatura alteraTemperatura) {
        Optional<Temperatura> existeTemperatura = temperaturaRepository.findById(id);
        if (existeTemperatura.isPresent()) {
            return temperaturaRepository.save(alteraTemperatura);
        } else {
            return null;
        }
    }

    public Boolean deletarTemperatura(Long id) {
        Optional<Temperatura> existeTemperatura = temperaturaRepository.findById(id);
        if (existeTemperatura.isPresent()) {
            temperaturaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
