package br.com.proiecte.service;

import br.com.proiecte.model.Projeto;
import br.com.proiecte.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    public ProjetoRepository projetoRepository;

    // método save()
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
    public void delete(Long id) {
        if (projetoRepository.existsById(id)) {
            projetoRepository.deleteById(id);
        } else {
            throw new RuntimeException("projeto não encontrado.");
        }
    }

}

