package controle.loja.api.domain.loja;


import controle.loja.api.domain.endereco.Endereco;

import java.time.LocalDateTime;

public record DetalhamentoLoja(Long id, String razaoSocial, String email,String telefone, Endereco endereco, LocalDateTime createdAt, LocalDateTime updatedAt) {
    public DetalhamentoLoja(Loja loja){
        this(loja.getId(), loja.getRazaoSocial(), loja.getEmail(), loja.getTelefone(), loja.getEndereco(), loja.getCreatedAt(), loja.getUpdatedAt());
    }
}
