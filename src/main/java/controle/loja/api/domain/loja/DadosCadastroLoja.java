package controle.loja.api.domain.loja;

import controle.loja.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;


public record DadosCadastroLoja(
        @NotBlank(message = "Razão Social é obrigatório")
        String razaoSocial,
        @Email(message = "Formato do email é inválido")
        String email,
        @NotBlank(message = "Nome é obrigatório")
        String cnpj,
        String telefone,
        @NotNull(message = "Dados do endereço são obrigatórios")
        @Valid DadosEndereco endereco){}
