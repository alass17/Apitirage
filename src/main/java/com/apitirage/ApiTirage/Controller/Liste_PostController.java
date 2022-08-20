package com.apitirage.ApiTirage.Controller;


import com.apitirage.ApiTirage.Service.Liste_PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/List_Post")
@AllArgsConstructor

public class Liste_PostController {
    private final Liste_PostService liste_postService;
}
