package br.com.empresa.pratica2.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.empresa.pratica2.model.AnexoCurriculo;
import br.com.empresa.pratica2.repository.AnexoCurriculoRepository;

@RestController
@RequestMapping("anexoscurriculos")
public class AnexoCurriculoResource {
    @Autowired
    private AnexoCurriculoRepository anexocurriculoRepository;

    @GetMapping
    public List<AnexoCurriculo> findAll() {
        return anexocurriculoRepository.findAll();
    }

}