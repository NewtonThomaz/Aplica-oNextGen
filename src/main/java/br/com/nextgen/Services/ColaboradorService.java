package br.com.nextgen.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.nextgen.Entities.Colaborador;
import br.com.nextgen.Repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }

    public Colaborador salvarColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public Colaborador buscarColaboradorId(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    public List<Colaborador> buscarTodosColaborador() {
        return colaboradorRepository.findAll();
    }

    public Colaborador alterarColaborador(Long id, Colaborador alteraColaborador) {
        Optional<Colaborador> existeColaborador = colaboradorRepository.findById(id);
        if (existeColaborador.isPresent()) {
            return colaboradorRepository.save(alteraColaborador);
        } else {
            return null;
        }
    }

    public Boolean deletarColaborador(Long id) {
        Optional<Colaborador> existeColaborador = colaboradorRepository.findById(id);
        if (existeColaborador.isPresent()) {
            colaboradorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
