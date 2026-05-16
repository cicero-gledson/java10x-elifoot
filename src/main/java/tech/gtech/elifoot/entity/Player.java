package tech.gtech.elifoot.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "player")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq_gen")
    @SequenceGenerator(name = "player_seq_gen", sequenceName = "player_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "shirt_number", nullable = false)
    private Integer shirtNumber;

    @Column(name = "url_img")
    private String urlImg;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;
}