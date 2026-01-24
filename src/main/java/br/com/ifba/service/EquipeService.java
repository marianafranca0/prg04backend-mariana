package br.com.ifba.service;

import br.com.ifba.model.Equipe;
import br.com.ifba.model.Projeto;
import br.com.ifba.repository.EquipeRepository;
import br.com.ifba.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipeService {

        private final EquipeRepository equipeRepository;
        private final ProjetoRepository projetoRepository;

        // método save()
        @Transactional
        public Equipe save(Equipe equipe, Long idProjeto) {
            Projeto projeto = projetoRepository.findById(idProjeto)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não encontrado"));

            equipe.setProjeto(projeto);

            return equipeRepository.save(equipe);
        }

        // método findAll()
        public List<Equipe> findAll() {
            return equipeRepository.findAll();
        }

        // método update()
        public void update(Equipe equipe) {
            Optional<Equipe> existe = equipeRepository.findById(equipe.getId());
            if (existe.isPresent()) {
                equipeRepository.save(equipe); // atualiza
            } else {
                throw new RuntimeException("Equipe não encontrada");
            }
        }

        // método delete()
        @Transactional
        public void delete(Long id) {
            if (equipeRepository.existsById(id)) {
                equipeRepository.deleteById(id);
            } else {
                throw new RuntimeException("Equipe não encontrada");
            }
        }
    }

