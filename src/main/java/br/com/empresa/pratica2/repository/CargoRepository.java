package br.com.empresa.pratica2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.empresa.pratica2.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}