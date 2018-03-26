package com.bdgx.guoi.station.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.Optional;

public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Post post) {
        return authorDao.getAuthor(post.getAuthorId());
    }
}
