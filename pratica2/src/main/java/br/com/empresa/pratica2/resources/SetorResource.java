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

import br.com.empresa.pratica2.model.Setor;
import br.com.empresa.pratica2.repository.SetorRepository;

@RestController
@RequestMapping("setor")
public class SetorResource {
    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public List<Setor> findAll() {
        return setorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Setor> salvar(@RequestBody Setor setor) {
        Setor setorSalvo = setorRepository.save(setor);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(setorSalvo.getIdsetor()).toUri();

        return ResponseEntity.created(location).body(setorSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Setor> findByCodigo(@PathVariable Integer codigo) {
        try {
            Setor setor = setorRepository.findById(codigo).get();

            return ResponseEntity.ok(setor);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        setorRepository.deleteById(codigo);
    }
}