package med.voll.api.domain.medico.records;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}