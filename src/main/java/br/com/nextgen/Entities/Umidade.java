package br.com.nextgen.Entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
	
	@NotBlank(message = "A umidade é um campo de preenchimento obrigatório")
	@NotNull(message = "A umidade é um campo de preenchimento obrigatório")
	private double umidade;
	
	@NotBlank(message = "O sensor de umidade é um campo de preenchimento obrigatório")
	@NotNull(message = "A sensor de umidade é um campo de preenchimento obrigatório")
	private String sensorUmidade;

	@NotBlank(message = "A data e a hora são um campo de preenchimento obrigatório")
	@NotNull(message = "A data e a hora são um campo de preenchimento obrigatório")
	private LocalDateTime dataHora;

	@NotBlank(message = "A umidade é um campo de preenchimento obrigatório")
	@NotNull(message = "A umidade é um campo de preenchimento obrigatório")
	@ManyToMany(mappedBy = "umidade")
	private List<Talhao> talhao;
}
