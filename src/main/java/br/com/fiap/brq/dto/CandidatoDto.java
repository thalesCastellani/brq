package br.com.fiap.brq.dto;

import java.time.LocalDateTime;

import br.com.fiap.brq.model.Candidato;
import br.com.fiap.brq.model.Genero;

public class CandidatoDto {

	public CandidatoDto(String nome, String cpf, String email, String telefone, Genero genero,
			LocalDateTime dataNascimento, String skill, String certificacao) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.skill = skill;
		this.certificacao = certificacao;
	}

	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Genero genero;
	private LocalDateTime dataNascimento;
	private String skill;
	private String certificacao;

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

	public String getSkill() {
		return skill;
	}

	public String getCertificacao() {
		return certificacao;
	}

	public Candidato converte(CandidatoDto candidatoDto) {
		
		String nome = candidatoDto.getNome();
		String cpf = candidatoDto.getCpf();
		String email = candidatoDto.getEmail();
		String telefone = candidatoDto.getTelefone();
		Genero genero = candidatoDto.getGenero();
		LocalDateTime dataNascimento = candidatoDto.getDataNascimento();
		String skill = candidatoDto.getSkill();
		String certificacao = candidatoDto.getCertificacao();
		
		Candidato candidato = new Candidato();
		
		candidato.setNome(nome);
		candidato.setCpf(cpf);
		candidato.setEmail(email);
		candidato.setTelefone(telefone);
		candidato.setGenero(genero);
		candidato.setDataNascimento(dataNascimento);
		candidato.setSkill(skill);
		candidato.setCertificacao(certificacao);
		
		return candidato;
		
	}

}
