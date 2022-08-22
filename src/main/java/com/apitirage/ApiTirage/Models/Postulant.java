package com.apitirage.ApiTirage.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTULANT")
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_post;
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    @JoinColumn(name = "Liste_id_post")
    private Liste_Post liste_post;

    @ManyToMany(mappedBy = "likedCourses")
    Set<Tirage> likes;

}
