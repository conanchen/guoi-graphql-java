package com.github.conanchen.guoi.graphql.types.common;

import lombok.Builder;
import lombok.Getter;

//# Information about pagination in a connection.
//types PageInfo {
//        # When paginating forwards, the cursor to continue.
//        endCursor: String
//
//        # When paginating forwards, are there more items?
//        hasNextPage: Boolean!
//
//        # When paginating backwards, are there more items?
//        hasPreviousPage: Boolean!
//
//        # When paginating backwards, the cursor to continue.
//        startCursor: String
//}
@Builder
@Getter
public class PageInfo {
    //        # When paginating forwards, the cursor to continue.
    private final String endCursor;//        endCursor: String
    //        # When paginating forwards, are there more items?
    private final Boolean hasNextPage;//        hasNextPage: Boolean!
    //        # When paginating backwards, are there more items?
    private final Boolean hasPreviousPage;//        hasPreviousPage: Boolean!
    //        # When paginating backwards, the cursor to continue.
    private final String startCursor;//        startCursor: String

    private Integer totalCount;

}
