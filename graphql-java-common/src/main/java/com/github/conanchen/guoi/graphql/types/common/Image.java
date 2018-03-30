package com.github.conanchen.guoi.graphql.types.common;

public class Image {
//    type Image {
//  # A unique identifier for the image.
private final String id;//        id: ID
//
//  # A word or phrase to share the nature or contents of an image.
private final String altText;//                altText: String
//
//  # The location of the image as a URL.
private final String src;//        src: URL!
//    }

    public Image(String id, String altText, String src) {
        this.id = id;
        this.altText = altText;
        this.src = src;
    }
}
