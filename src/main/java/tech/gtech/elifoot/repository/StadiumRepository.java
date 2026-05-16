package tech.gtech.elifoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.gtech.elifoot.entity.Stadium;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
