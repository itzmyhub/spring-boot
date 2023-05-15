package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.DadosEndereco;
import med.voll.api.domain.paciente.records.AtualizacaoPaciente;
import med.voll.api.domain.paciente.records.CadastroPaciente;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private DadosEndereco endereco;

    private boolean ativo;


    public Paciente(CadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new DadosEndereco(dados.endereco());
    }

    public void atualizarInformacoes(AtualizacaoPaciente dados) {
        if(this.nome != null) {
            this.nome = dados.nome();
        }
        if(this.telefone != null) {
            this.telefone = dados.telefone();
        }
        if(this.endereco != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void tornarUsuarioInativo() {
        this.ativo = false;
    }

}
