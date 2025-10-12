package br.com.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nextgen.Entities.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
