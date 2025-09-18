package br.com.nextgen.Repository;

import br.com.nextgen.Entities.Cultura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CulturaRepository extends JpaRepository<Cultura, Long> {
}
