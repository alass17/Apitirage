package com.apitirage.ApiTirage.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "LISTE_POST")
@NoArgsConstructor
public class Liste_Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_listepost;
    private  String date;
    private  String libelle;

}
