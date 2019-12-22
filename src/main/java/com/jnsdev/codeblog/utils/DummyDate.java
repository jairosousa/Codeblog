package com.jnsdev.codeblog.utils;

import com.jnsdev.codeblog.model.Post;
import com.jnsdev.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyDate {

    @Autowired
    CodeblogRepository codeblogRepository;

    /**
     * Rodar uma vez e depois comentar o PostConstruct
     * senão vai ficar gerando novos dois registros no banco
     * toda vez que reiniciar o servidor.
     */
    //@PostConstruct
    public void savePost(){
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Jairo Nascimento");
        post1.setData(LocalDate.now());
        post1.setTitulo("API REST");
        post1.setTexto("t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");

        Post post2 = new Post();
        post2.setAutor("Silvana Sousa");
        post2.setData(LocalDate.now());
        post2.setTitulo("DOCKER");
        post2.setTexto("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");

        postList.add(post1);
        postList.add(post2);

        for (Post post : postList) {
            Post postSave = codeblogRepository.save(post);
            System.out.println(postSave.getId());
        }
    }
}
