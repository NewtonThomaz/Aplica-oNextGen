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
public class Temperatura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "A temperatura é um campo de preenchimento obrigatório")
	@NotNull(message = "A temperatura é um campo de preenchimento obrigatório")
	private double temperatura;
	
	@NotBlank(message = "O sensor de temperatura é um campo de preenchimento obrigatório")
	@NotNull(message = "O sensor de temperatura é um campo de preenchimento obrigatório")
	private String sensorTemperatura;
	
	@NotBlank(message = "A data e a hora são um campo de preenchimento obrigatório")
	@NotNull(message = "A data e a hora são um campo de preenchimento obrigatório")
	private LocalDateTime dataHora;

	@NotBlank(message = "A temperatura é um campo de preenchimento obrigatório")
	@NotNull(message = "A temperatura é um campo de preenchimento obrigatório")
	@ManyToMany(mappedBy = "temperatura")
	private List<Talhao> talhao;
}
