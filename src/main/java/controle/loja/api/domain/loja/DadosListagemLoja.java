package controle.loja.api.domain.loja;


import controle.loja.api.domain.endereco.Endereco;

import java.time.LocalDateTime;

public record DadosListagemLoja(
        Long id,
        String razaoSocial,
        String email, String telefone, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public DadosListagemLoja(Loja loja){
        this(loja.getId(), loja.getRazaoSocial(), loja.getEmail(), loja.getTelefone(), loja.getCreatedAt(), loja.getUpdatedAt());
    }
}
