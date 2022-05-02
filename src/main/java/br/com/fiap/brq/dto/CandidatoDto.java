package br.com.fiap.brq.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Pattern;

import br.com.fiap.brq.model.Candidato;
import br.com.fiap.brq.model.Genero;
import br.com.fiap.brq.model.Skill;

public class CandidatoDto {

	public CandidatoDto(String nome, String cpf, String email, String telefone, Genero genero,
			LocalDateTime dataNascimento, List<SkillDto> skill, String certificacao) {
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
	@Pattern(regexp = "^([0-9]{3}\\.?){3}-?[0-9]{2}$", message = "Deve seguir o padrão: 000.000.000-00")
	private String cpf;
	@Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Deve seguir o padrão: nome@email.com")
	private String email;
	@Pattern(regexp = "^((\\(\\d{2}\\))|\\d{2})[- .]?\\d{5}[- .]?\\d{4}$", message = "Deve seguir o padrão: (11) 99999-9999")
	private String telefone;
	private Genero genero;
	private LocalDateTime dataNascimento;
	private List<SkillDto> skill;
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

	public List<SkillDto> getSkill() {
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

		List<SkillDto> skillDto = candidatoDto.getSkill();
		List<Skill> skills = Skill.converte(skillDto);

		String certificacao = candidatoDto.getCertificacao();

		Candidato candidato = new Candidato();

		candidato.setNome(nome);
		candidato.setCpf(cpf);
		candidato.setEmail(email);
		candidato.setTelefone(telefone);
		candidato.setGenero(genero);
		candidato.setDataNascimento(dataNascimento);
		candidato.setSkills(skills);
		candidato.setCertificacao(certificacao);

		return candidato;

	}

}
