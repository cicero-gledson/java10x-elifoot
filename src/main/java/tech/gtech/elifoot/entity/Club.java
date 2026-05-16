package tech.gtech.elifoot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "club")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_seq_gen")
    @SequenceGenerator(name = "club_seq_gen", sequenceName = "club_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    // mapped to DATE column 'founded'
    @Column(nullable = false)
    private LocalDate founded;

    // coluna url_img no banco
    @Column(name = "url_img")
    private String urlImg;

    // coluna created_at no banco (TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private Boolean active;

    // a tabela DEFINE stadium_id UNIQUE e FK -> mapeamos como OneToOne
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", unique = true)
    private Stadium stadium;

    @OneToMany(mappedBy = "club")
    private List<Player> players;
}