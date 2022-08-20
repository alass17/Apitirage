package com.apitirage.ApiTirage.Service;

import com.apitirage.ApiTirage.Models.Postulant;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface PostulantService {

    //List<Postulant> importer(List<Postulant> postulant);

    Postulant ajouter (Postulant postulant);

    List<Postulant> lire();

    Postulant modifier(Long id, Postulant postulant);

    String supprimer(Long id);

    Iterable<Object[]>listerPost();

    List<Postulant> excelImporter(MultipartFile fichier);
}
