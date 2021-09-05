package br.com.framework.desafio.service;

import br.com.framework.desafio.client.JSONPlaceHolderClient;
import br.com.framework.desafio.domain.Album;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AlbumService {

    @Autowired
    public JSONPlaceHolderClient jsonPlaceHolderClient;

    public List<Album> getAllAlbums(){
        log.info("METHOD: getAllAlbums");
        return jsonPlaceHolderClient.getAllAlbums();
    }

}
