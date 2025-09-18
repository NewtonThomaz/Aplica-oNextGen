package br.com.nextgen.Entities;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE talhao SET ativo = false WHERE id=?")
@Where(clause = "ativo = true")
public class Talhao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é um campo de preenchimento obrigatório")
    private String nome;

    @Size(max = 250, message = "O número máximo de caracteres é 250")
    private String descricao;

    @NotNull(message = "O tamanho é um campo de preenchimento obrigatório")
    private double tamanho;

    @NotNull(message = "A unidade de medida é um campo de preenchimento obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "unidade-medida")
    private UnidadeMedida unidadeMedida;

    // Campo q a erica pediu
    @Column(columnDefinition = "boolean default true")
    private boolean ativo = true;

    @OneToOne @MapsId
    private Usuario usuario_id;

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
}