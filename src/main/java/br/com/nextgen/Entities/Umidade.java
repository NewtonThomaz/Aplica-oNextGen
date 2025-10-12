package br.com.nextgen.Entities;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Umidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotNull(message = "A umidade é um campo de preenchimento obrigatório")
	private double umidade;
	

	@NotNull(message = "A sensor de umidade é um campo de preenchimento obrigatório")
	private String sensorUmidade;


	@NotNull(message = "A data e a hora são um campo de preenchimento obrigatório")
	private LocalDateTime dataHora;


	@NotNull(message = "A umidade é um campo de preenchimento obrigatório")
	@ManyToMany(mappedBy = "umidade")
	private List<Talhao> talhao;
}
