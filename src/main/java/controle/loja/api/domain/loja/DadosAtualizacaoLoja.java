package controle.loja.api.domain.loja;

//import jakarta.validation.Valid;
import controle.loja.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;


public record DadosAtualizacaoLoja(

        @NotNull
        Long id,
        String razaoSocial,

        @Email(message = "Formato do email é inválido")
        String email,

        String cnpj,

        String telefone,

        DadosEndereco endereco){}
