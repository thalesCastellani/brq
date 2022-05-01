package br.com.fiap.brq.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fiap.brq.dto.SkillDto;

@Entity
@Table(name = "TB_BRQ_SKILL")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Long id;

	@Column(name = "nm_skill", nullable = true)
	private String nome;
	
	public Skill() {}

	public Skill(SkillDto skillDto) {
		this.nome = skillDto.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<Skill> converte(List<SkillDto> skillsDto) {
		return skillsDto.stream().map(Skill::new).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skill other = (Skill) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
