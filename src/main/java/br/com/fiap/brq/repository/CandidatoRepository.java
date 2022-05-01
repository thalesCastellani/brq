package br.com.fiap.brq.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.brq.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

	Page<Candidato> findBySkill_Nome(String skill, Pageable paginacao);

	Optional<Candidato> findByNome(String nome);

	Optional<Candidato> findByEmail(String email);

	Optional<Candidato> findByCpf(String cpf);

	Optional<Candidato> findByCertificacao(String certificacao);

}
