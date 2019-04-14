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

import br.com.empresa.pratica2.model.Anexo;
import br.com.empresa.pratica2.repository.AnexoRepository;

@RestController
@RequestMapping("anexos")
public class AnexoResource {
    @Autowired
    private AnexoRepository anexoRepository;

    @GetMapping
    public List<Anexo> findAll() {
        return anexoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Anexo> salvar(@RequestBody Anexo anexo) {
        Anexo anexoSalvo = anexoRepository.save(anexo);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(anexoSalvo.getIdanexo()).toUri();

        return ResponseEntity.created(location).body(anexoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Anexo> findByCodigo(@PathVariable Integer codigo) {
        try {
            Anexo cargo = anexoRepository.findById(codigo).get();

            return ResponseEntity.ok(cargo);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        anexoRepository.deleteById(codigo);
    }
}