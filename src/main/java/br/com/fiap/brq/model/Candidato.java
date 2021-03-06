package br.com.fiap.brq.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private LocalDateTime dataNascimento;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Column(name = "ds_skills")
	private List<Skill> skill;

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

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public List<Skill> getSkills() {
		return skill;
	}

	public String getCertificacao() {
		return certificacao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setSkills(List<Skill> skills) {
		this.skill = skills;
	}

	public void setCertificacao(String certificacao) {
		this.certificacao = certificacao;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone=" + telefone
				+ ", genero=" + genero + ", dataNascimento=" + dataNascimento + ", skills=" + skill + ", certificacao="
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
