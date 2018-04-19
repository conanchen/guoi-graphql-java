package com.github.conanchen.guoi.graphql.types.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Image {
    //  # A unique identifier for the image.
    private String id;//        id: ID

    //  # A word or phrase to share the nature or contents of an image.
    private String altText;//                altText: String

    //  # The location of the image as a URL.
    private String src;//        src: URL!
}
