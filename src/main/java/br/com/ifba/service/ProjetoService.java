package br.com.ifba.service;

import br.com.ifba.model.Projeto;
import br.com.ifba.repository.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    public ProjetoRepository projetoRepository;

    // método save()
    @Transactional
    public Projeto save(Projeto projeto){
        return projetoRepository.save(projeto);

    }

    // método findAll()
    public List<Projeto> findAll(){
        return projetoRepository.findAll();
  }

    // método update()
    public void update(Projeto projeto){
        // verifica se o projeto existe antes de atualizar
        Optional<Projeto> existe = projetoRepository.findById(projeto.getId());
        if(existe.isPresent()) {
            projetoRepository.save(projeto); // atualiza
        } else{
            throw new RuntimeException("projeto não encontrado.");
        }
    }

    // método delete()
    @Transactional
    public void delete(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
        } else {
            throw new RuntimeException("projeto não encontrado.");
        }
    }

}

