package br.com.empresa.pratica2.resources;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.empresa.pratica2.model.Curriculo;
import br.com.empresa.pratica2.repository.CurriculoRepository;

@RestController
@RequestMapping("curriculos")
public class CurriculoResource {
    @Autowired
    private CurriculoRepository curriculoRepository;

    @GetMapping
    public List<Curriculo> findAll() {
        return curriculoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Curriculo> salvar(@RequestBody Curriculo curriculo) {
        Curriculo curriculoSalvo = curriculoRepository.save(curriculo);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(curriculoSalvo.getIdcurriculo()).toUri();

        return ResponseEntity.created(location).body(curriculoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Curriculo> findByCodigo(@PathVariable Integer codigo) {
        try {
            Curriculo curriculo = curriculoRepository.findById(codigo).get();

            return ResponseEntity.ok(curriculo);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        curriculoRepository.deleteById(codigo);
    }
}