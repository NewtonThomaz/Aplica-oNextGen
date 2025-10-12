package br.com.nextgen.Entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    // @NotNull é redundante com @NotBlank, que já inclui a verificação de nulo.
    private String operacao;

    @NotBlank(message = "O agente é um campo de preenchimento obrigatório")
    @Size(max = 25)
    private String agente;

    // CORREÇÃO: Removido @NotBlank, pois dataHora não é uma String.
    @NotNull(message = "A data e a hora são um campo de preenchimento obrigatório")
    private LocalDateTime dataHora;

    // As anotações de validação para a lista de Talhao não são necessárias aqui, pois a validação deve ser feita no serviço.
    @ManyToMany(mappedBy = "operacao")
    private List<Talhao> talhao;
}