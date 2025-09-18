package br.com.nextgen.Entities;

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
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O tipo de permissão é um campo de preenchimento obrigatório")
    @NotNull(message = "O tipo de permissão é um campo de preenchimento obrigatório")
    @Enumerated(EnumType.STRING)
    private Permissoes tipoPermissao;

    //FK
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id-usuario")
    private Usuario usuario;

    @NotBlank(message = "O talhão é um campo de preenchimento obrigatório")
    @NotNull(message = "O talhão é um campo de preenchimento obrigatório")
    @ManyToMany(mappedBy = "colaborador")
    private List<Talhao> talhao;
}
