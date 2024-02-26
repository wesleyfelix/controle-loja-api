package controle.loja.api.domain.loja;

import controle.loja.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Table(name = "lojas")
@Entity(name = "Loja")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Loja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String razaoSocial;
    private String cnpj;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;

    @Column(name = "createdat", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updatedat")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Loja(DadosCadastroLoja dados) {
        this.razaoSocial = dados.razaoSocial();
        this.cnpj = dados.cnpj();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void AtualizarInformacoes(DadosAtualizacaoLoja dados) {

        if(dados.razaoSocial() != null){
            this.razaoSocial = dados.razaoSocial();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

        if(dados.cnpj() != null){
            this.cnpj = dados.cnpj();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }


    }
}
