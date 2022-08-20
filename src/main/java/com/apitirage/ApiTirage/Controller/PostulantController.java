package com.apitirage.ApiTirage.Controller;

import com.apitirage.ApiTirage.Models.ExcelConfig;
import com.apitirage.ApiTirage.Models.Postulant;
import com.apitirage.ApiTirage.Repository.PostulantRepo;
import com.apitirage.ApiTirage.Service.PostulantService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RequestMapping("/postulant")
@AllArgsConstructor
@RestController
public class PostulantController {
    private final PostulantRepo postulantRepo;

    @RequestMapping("/import/excel")
    @ResponseBody
    public String importexcel(@Param("file")MultipartFile file){
        ExcelConfig excelConfig=new ExcelConfig();
        List<Postulant> postulantList=excelConfig.postulantsExcel(file);
        if(postulantList != null){
            postulantRepo.saveAll(postulantList);
            //   postulantService.enregistrer(postulantList);

            return "Importer avec succes";
        }else{
            return "Erreur d'importation !";
        }

    }

    private final PostulantService postulantService;

    //Lister les postulants @GetMapping("/listerPostulants")
    public Iterable<Object[]> listerPostulants() {
        return this.postulantService.listerPost(); }

    @PostMapping("/ajouter")
   // @ApiOperation(value = "Just to test the sample test api of My App Service")
    public Postulant ajouter(@RequestBody Postulant postulant) {
        return this.postulantService.ajouter(postulant);
    }

    // @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/lire")
    public List<Postulant> lire(){
        return this.postulantService.lire();
    }

}


