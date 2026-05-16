package tech.gtech.elifoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.gtech.elifoot.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
