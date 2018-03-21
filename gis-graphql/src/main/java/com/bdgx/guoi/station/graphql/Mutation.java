package com.bdgx.guoi.station.graphql;

import com.bdgx.guoi.station.graphql.mongo.CustomerRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mutation implements GraphQLMutationResolver {
    private PostDao postDao;

    @Autowired
    private CustomerRepository customerRepository;

    public Mutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String title, String text, String category, String author) {
        Post post = new Post();
        post.setId(UUID.randomUUID()
                .toString());
        post.setTitle(title);
        post.setText(text + " customerRepository="+customerRepository.toString());
        post.setCategory(category);
        post.setAuthorId(author);
        postDao.savePost(post);

        return post;
    }

    public Post writePostWithInput(PostInput postInput) {
        Post post = new Post();
        post.setId(UUID.randomUUID()
                .toString());
        post.setTitle(postInput.getTitle());
        post.setText(postInput.getText());
        post.setCategory(postInput.getCategory());
        post.setAuthorId(postInput.getAuthorId());
        postDao.savePost(post);

        return post;
    }
}
