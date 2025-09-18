package br.com.nextgen.Entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O operação é um campo de preenchimento obrigatório")
	@NotNull(message = "O operação é um campo de preenchimento obrigatório")
	private String operacao;
	
	@NotBlank(message = "O agente é um campo de preenchimento obrigatório")
	@NotNull(message = "O agente é um campo de preenchimento obrigatório")
	@Size(max = 25)
	private String agente;

	@NotBlank(message = "A data e a hora são um campo de preenchimento obrigatório")
	@NotNull(message = "A data e a hora são um campo de preenchimento obrigatório")
	private LocalDateTime dataHora;

	@NotBlank(message = "O talhao é um campo de preenchimento obrigatório")
	@NotNull(message = "O talhao é um campo de preenchimento obrigatório")
	@ManyToMany(mappedBy = "operacao")
	private List<Talhao> talhao;
}
