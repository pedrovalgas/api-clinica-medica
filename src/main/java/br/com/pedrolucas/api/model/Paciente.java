package br.com.pedrolucas.api.model;

import br.com.pedrolucas.api.dto.paciente.DadosAtualizacaoPaciente;
import br.com.pedrolucas.api.dto.paciente.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import br.com.pedrolucas.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity(name = "Paciente")
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
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }
}
