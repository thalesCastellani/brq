package br.com.fiap.brq.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.brq.dto.CandidatoDto;
import br.com.fiap.brq.model.Candidato;
import br.com.fiap.brq.repository.CandidatoRepository;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@GetMapping
	public List<Candidato> lista() {
		List<Candidato> candidatos = candidatoRepository.findAll();
		return candidatos;
	}
	
	@GetMapping(value = "/skill/{skill}")
	public ResponseEntity<Page<Candidato>> buscaInfosCandidatoPorSkill(@PathVariable String skill) {
		
		Pageable paginacao = PageRequest.of(0, 10, Sort.by(
				List.of(
						new Sort.Order(Sort.Direction.ASC, "skill"),
						new Sort.Order(Sort.Direction.DESC, "certificacao", Sort.NullHandling.NULLS_LAST),
						new Sort.Order(Sort.Direction.ASC, "nome")
						)
				));
		
		Page<Candidato> candidatos = candidatoRepository.findBySkill_Nome(skill, paginacao);
		
		if (!candidatos.isEmpty()) {
			return ResponseEntity.ok(candidatos);
		}
		
		return ResponseEntity.notFound().build();
	}
		
	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<Candidato> buscaInfosCandidatoPorNome(@PathVariable String nome) {
		Optional<Candidato> candidato = candidatoRepository.findByNome(nome);
		
		if (candidato.isPresent()) {
			return ResponseEntity.ok(candidato.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Candidato> buscaInfosCandidatoPorEmail(@PathVariable String email) {
		Optional<Candidato> candidato = candidatoRepository.findByEmail(email);
		
		if (candidato.isPresent()) {
			return ResponseEntity.ok(candidato.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/cpf/{cpf}")
	public ResponseEntity<Candidato> buscaInfosCandidatoPorCpf(@PathVariable String cpf) {
		Optional<Candidato> candidato = candidatoRepository.findByCpf(cpf);
		
		if (candidato.isPresent()) {
			return ResponseEntity.ok(candidato.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/certificacao/{certificacao}")
	public ResponseEntity<Candidato> buscaInfosCandidatoPorCertificacao(@PathVariable String certificacao) {
		Optional<Candidato> candidato = candidatoRepository.findByCertificacao(certificacao);
		
		if (candidato.isPresent()) {
			return ResponseEntity.ok(candidato.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Candidato> cadastra(@RequestBody CandidatoDto candidatoDto, UriComponentsBuilder uriComponentsBuilder) {
		
		Candidato candidato = candidatoDto.converte(candidatoDto);
		
		candidatoRepository.save(candidato);
		
		URI uri = uriComponentsBuilder.path("/candidato/{id}").buildAndExpand(candidato.getId()).toUri();
		return ResponseEntity.created(uri).body(candidato);
	}
	

}
