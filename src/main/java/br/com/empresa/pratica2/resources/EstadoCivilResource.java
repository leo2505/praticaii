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

import br.com.empresa.pratica2.model.EstadoCivil;
import br.com.empresa.pratica2.repository.EstadoCivilRepository;

@RestController
@RequestMapping("estadocivil")
public class EstadoCivilResource {
    @Autowired
    private EstadoCivilRepository estadocivilRepository;

    @GetMapping
    public List<EstadoCivil> findAll() {
        return estadocivilRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<EstadoCivil> salvar(@RequestBody EstadoCivil estadoCivil) {
        EstadoCivil estadocivilSalvo = estadocivilRepository.save(estadoCivil);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(estadocivilSalvo.getIdestadocivil()).toUri();

        return ResponseEntity.created(location).body(estadocivilSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<EstadoCivil> findByCodigo(@PathVariable Integer codigo) {
        try {
            EstadoCivil estadoCivil = estadocivilRepository.findById(codigo).get();

            return ResponseEntity.ok(estadoCivil);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        estadocivilRepository.deleteById(codigo);
    }
}