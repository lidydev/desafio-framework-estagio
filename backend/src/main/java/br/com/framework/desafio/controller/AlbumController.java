package br.com.framework.desafio.controller;

import br.com.framework.desafio.domain.Album;
import br.com.framework.desafio.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @Cacheable(value = "albumCache")
    @GetMapping("")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

}
