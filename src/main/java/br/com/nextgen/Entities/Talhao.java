package br.com.nextgen.Entities;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Talhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é um campo de preenchimento obrigatório")
    @NotNull(message = "O nome é um campo de preenchimento obrigatório")
    private String nome;

    @Size(max = 250, message = "O número maximo de caracteres é 250")
    private String descricao;

    @NotBlank(message = "O tamanho é um campo de preenchimento obrigatório")
    @NotNull(message = "O tamanho é um campo de preenchimento obrigatório")
    private double tamanho;

    @NotBlank(message = "O unidade de medida é um campo de preenchimento obrigatório")
    @NotNull(message = "O unidade de medida é um campo de preenchimento obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "unidade-medida")
    private UnidadeMedida unidadeMedida;

    //FK
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id-usuario")
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "talhao/colaborador",
            joinColumns = @JoinColumn(name = "id-talhao"),
            inverseJoinColumns = @JoinColumn(name = "id-colaborador"))
    private List<Colaborador> colaborador;

    @ManyToMany
    @JoinTable(name = "talhao/cultura",
            joinColumns = @JoinColumn(name = "id-talhao"),
            inverseJoinColumns = @JoinColumn(name = "id-cultura"))
    private List<Cultura> cultura;


    @ManyToMany
    @JoinTable(name = "talhao/operacao",
            joinColumns = @JoinColumn(name = "id-talhao"),
            inverseJoinColumns = @JoinColumn(name = "id-operacao"))
    private List<Operacao> operacao;

    @ManyToMany
    @JoinTable(name = "talhao/umidade",
            joinColumns = @JoinColumn(name = "id-talhao"),
            inverseJoinColumns = @JoinColumn(name = "id-umidade"))
    private List<Umidade> umidade;

    @ManyToMany
    @JoinTable(name = "talhao/temperatura",
            joinColumns = @JoinColumn(name = "id-talhao"),
            inverseJoinColumns = @JoinColumn(name = "id-temperatura"))
    private List<Temperatura> temperatura;
}
