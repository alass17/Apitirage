package com.apitirage.ApiTirage.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TIRAGE")
@Getter
@Setter
@NoArgsConstructor

public class Tirage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id_tirage;
        private Long date;
        private String libelle;
        private Long nbre_postulant;
        private Long nombre;


    @ManyToMany
    @JoinTable(
            name = "Postulant_tire",
            joinColumns = @JoinColumn(name = "id_post"),
            inverseJoinColumns = @JoinColumn(name = "id_tirage"))
    Set<Postulant> likedCourses;
}
