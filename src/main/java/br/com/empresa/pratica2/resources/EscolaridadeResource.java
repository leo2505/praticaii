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

import br.com.empresa.pratica2.model.Escolaridade;
import br.com.empresa.pratica2.repository.EscolaridadeRepository;

@RestController
@RequestMapping("escolaridade")
public class EscolaridadeResource {
    @Autowired
    private EscolaridadeRepository escolaridadeRepository;

    @GetMapping
    public List<Escolaridade> findAll() {
        return escolaridadeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Escolaridade> salvar(@RequestBody Escolaridade escolaridade) {
        Escolaridade escolaridadeSalvo = escolaridadeRepository.save(escolaridade);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(escolaridadeSalvo.getIdescolaridade()).toUri();

        return ResponseEntity.created(location).body(escolaridadeSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Escolaridade> findByCodigo(@PathVariable Integer codigo) {
        try {
            Escolaridade escolaridade = escolaridadeRepository.findById(codigo).get();

            return ResponseEntity.ok(escolaridade);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        escolaridadeRepository.deleteById(codigo);
    }
}