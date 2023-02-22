package com.github.marceloasfilho.humanresources.repository;

import com.github.marceloasfilho.humanresources.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
