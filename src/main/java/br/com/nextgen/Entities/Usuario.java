package br.com.nextgen.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "URL da Foto de Perfil")
	private String fotoPerfil;

	@NotBlank(message = "O nome é um campo de preenchimento obrigatório")
	@NotNull(message = "O nome é um campo de preenchimento obrigatório")
	@Size(max = 100, message = "O número maximo de caracteres é 100")
	private String nome;

	@NotBlank(message = "O email é um campo de preenchimento obrigatório")
	@Email(message = "Insira um email valido")
	@Size(max = 100, message = "O número maximo de caracteres é 100")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "A senha não pode estar vazia")
    @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres")
	@Pattern(
			regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).*$",
			message = "A senha deve conter ao menos: uma letra maiúscula, uma letra minúscula, um número e um caractere especial"
			)
	private String senha;

}
