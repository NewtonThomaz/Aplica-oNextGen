package br.com.nextgen.Repository;

import br.com.nextgen.Entities.Talhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Talhao, Long> {
}
