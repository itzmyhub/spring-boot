package med.voll.api.domain.paciente.records;

import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.paciente.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, DadosEndereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
