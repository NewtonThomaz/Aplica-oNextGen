package br.com.nextgen.Repository;

import br.com.nextgen.Entities.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperaturaRepository extends JpaRepository<Temperatura, Long> {
}
