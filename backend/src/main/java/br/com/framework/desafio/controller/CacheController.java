package br.com.framework.desafio.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/cache")
public class CacheController {

    @CacheEvict(value = { "postCache", "AlbumCache", "todoCache" }, allEntries = true)
    @GetMapping("/clean")
    public ResponseEntity<?> cleanCache() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }

}
