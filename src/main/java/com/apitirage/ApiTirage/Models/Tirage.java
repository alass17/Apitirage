package com.apitirage.ApiTirage.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TIRAGE")
@Getter
@Setter
@NoArgsConstructor
public class Tirage {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id_tirage;
        private String libelle;
}
