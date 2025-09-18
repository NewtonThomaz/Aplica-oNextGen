package br.com.nextgen.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cultura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é um campo de preenchimento obrigatório")
    @NotNull(message = "O nome é um campo de preenchimento obrigatório")
    @Size(max = 100, message = "O número maximo de caracteres é 100")
    private String nome;

    @NotBlank(message = "A data é um campo de preenchimento obrigatório")
    @NotNull(message = "A data é um campo de preenchimento obrigatório")
    private Date data;

    //FK
    @NotBlank(message = "A cultura é um campo de preenchimento obrigatório")
    @NotNull(message = "A cultura é um campo de preenchimento obrigatório")
    @ManyToMany(mappedBy = "cultura")
    private List<Talhao> talhao;
}
