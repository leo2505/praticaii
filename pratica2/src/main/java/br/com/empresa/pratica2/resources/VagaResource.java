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

import br.com.empresa.pratica2.model.Vaga;
import br.com.empresa.pratica2.repository.VagaRepository;

@RestController
@RequestMapping("vagas")
public class VagaResource {
    @Autowired
    private VagaRepository vagaRepository;

    @GetMapping
    public List<Vaga> findAll() {
        return vagaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Vaga> salvar(@RequestBody Vaga vaga) {
        Vaga vagaSalvo = vagaRepository.save(vaga);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(vagaSalvo.getIdvaga()).toUri();

        return ResponseEntity.created(location).body(vagaSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Vaga> findByCodigo(@PathVariable Integer codigo) {
        try {
            Vaga vaga = vagaRepository.findById(codigo).get();

            return ResponseEntity.ok(vaga);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        vagaRepository.deleteById(codigo);
    }
}