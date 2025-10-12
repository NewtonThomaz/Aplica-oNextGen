package br.com.nextgen.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cultura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "O nome é um campo de preenchimento obrigatório")
    @Size(max = 100, message = "O número maximo de caracteres é 100")
    private String nome;


    @NotNull(message = "A data é um campo de preenchimento obrigatório")
    private Date data;

    //FK
    @NotNull(message = "A cultura é um campo de preenchimento obrigatório")
    @ManyToMany(mappedBy = "cultura")
    private List<Talhao> talhao;
}
