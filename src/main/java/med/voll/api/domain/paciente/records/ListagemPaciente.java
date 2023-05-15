package med.voll.api.domain.paciente.records;

import med.voll.api.domain.paciente.Paciente;

public record ListagemPaciente(Long id, String nome, String email, String cpf) {

    public ListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
