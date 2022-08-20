package com.apitirage.ApiTirage.Service;
import com.apitirage.ApiTirage.Models.Postulant;
import com.apitirage.ApiTirage.Repository.PostulantRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PostulantServiceImpl implements PostulantService{

    @Autowired
    public final PostulantRepo postulantRepo;
    /*@Override
    public List<Postulant> importer(List<Postulant> postulant) {
        return postulantRepo.saveAll(postulant);
    }
*/


    @Override
    public Postulant ajouter(Postulant postulant) {
        return postulantRepo.save(postulant);
    }

    @Override
    public List<Postulant> lire() {
        return postulantRepo.findAll();
    }

    @Override
    public Postulant modifier(Long id, Postulant postulant) {
        return postulantRepo.findById(id)
        .map(r -> {
            r.setNom(postulant.getNom());
            r.setPrenom(postulant.getPrenom());
            r.setNumero(postulant.getNumero());
            r.setEmail(postulant.getEmail());
            return postulantRepo.save(r);
        }).orElseThrow(() -> new RuntimeException("Postulant non trouvé!"));

    }

    @Override
    public String supprimer(Long id) {
        postulantRepo.deleteById(id);
        return "Liste supprimée";
    }

    @Override
    public Iterable<Object[]> listerPost() {
        return null;
    }

    @Override
    public List<Postulant> excelImporter(MultipartFile fichier) {
        return null;
    }
    // @Override
   // public Iterable<Object[]> listerPost() {
       // return null;
   // }
}

