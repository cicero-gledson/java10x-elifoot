package tech.gtech.elifoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.gtech.elifoot.entity.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
