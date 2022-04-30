package br.com.fiap.brq.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TB_BRQ_CANDIDATO")
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidato")
	private Long id;

	@Column(name = "nm_candidato", nullable = false)
	private String nome;

	@Column(name = "nr_cpf", nullable = false, unique = true)
	private String cpf;

	@Column(name = "ds_email", nullable = false, unique = true)
	private String email;

	@Column(name = "nr_telefone", nullable = false, unique = true)
	private String telefone;

	@Column(name = "tp_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "dt_nascimento")
	@JsonProperty("data_nascimento")
	private String dataNascimento;

	@Column(name = "ds_skill", nullable = true)
	private String skill;

	@Column(name = "nm_certificacao")
	private String certificacao;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public Genero getGenero() {
		return genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getSkill() {
		return skill;
	}

	public String getCertificacao() {
		return certificacao;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", genero=" + genero + ", dataNascimento=" + dataNascimento + ", skill=" + skill + ", certificacao="
				+ certificacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(certificacao, cpf, dataNascimento, email, genero, id, nome, skill, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(certificacao, other.certificacao) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& genero == other.genero && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(skill, other.skill) && Objects.equals(telefone, other.telefone);
	}

}
