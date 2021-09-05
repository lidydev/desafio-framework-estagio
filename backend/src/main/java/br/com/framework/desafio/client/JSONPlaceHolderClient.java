package br.com.framework.desafio.client;

import br.com.framework.desafio.domain.Album;
import br.com.framework.desafio.domain.Post;
import br.com.framework.desafio.domain.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(
        value="JSONPlaceHolderClient",
        url="${json.place.holder.base.url}"
)
public interface JSONPlaceHolderClient {

    @GetMapping("posts")
    List<Post> getAllPosts();

    @GetMapping("albums")
    List<Album> getAllAlbums();

    @GetMapping("todos")
    List<Todo> getAllTodos();

}
