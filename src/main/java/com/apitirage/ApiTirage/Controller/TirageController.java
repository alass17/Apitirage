package com.apitirage.ApiTirage.Controller;

import com.apitirage.ApiTirage.Models.Tirage;
import com.apitirage.ApiTirage.Service.TirageSevice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/Tirage")

public class TirageController {
    private  final TirageSevice tirageSevice;
    @PostMapping ("/trier")
    public Tirage trier (@RequestBody Tirage tirage){
        return tirageSevice.trier(tirage);
    }
}
