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

import br.com.empresa.pratica2.model.Cargo;
import br.com.empresa.pratica2.repository.CargoRepository;

@RestController
@RequestMapping("cargos")
public class CargoResource {
    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cargo> salvar(@RequestBody Cargo cargo) {
        Cargo cargoSalvo = cargoRepository.save(cargo);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{codigo}")
                .buildAndExpand(cargoSalvo.getIdcargo()).toUri();

        return ResponseEntity.created(location).body(cargoSalvo);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cargo> findByCodigo(@PathVariable Integer codigo) {
        try {
            Cargo cargo = cargoRepository.findById(codigo).get();

            return ResponseEntity.ok(cargo);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer codigo) {
        cargoRepository.deleteById(codigo);
    }
}