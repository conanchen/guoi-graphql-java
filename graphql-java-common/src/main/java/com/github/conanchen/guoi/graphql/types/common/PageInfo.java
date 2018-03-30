package com.github.conanchen.guoi.graphql.types.common;

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
public class PageInfo {
    //        # When paginating forwards, the cursor to continue.
    private final String endCursor;//        endCursor: String
    //        # When paginating forwards, are there more items?
    private final Boolean hasNextPage;//        hasNextPage: Boolean!
    //        # When paginating backwards, are there more items?
    private final Boolean hasPreviousPage;//        hasPreviousPage: Boolean!
    //        # When paginating backwards, the cursor to continue.
    private final String startCursor;//        startCursor: String

    public PageInfo(String endCursor, Boolean hasNextPage, Boolean hasPreviousPage, String startCursor) {
        this.endCursor = endCursor;
        this.hasNextPage = hasNextPage;
        this.hasPreviousPage = hasPreviousPage;
        this.startCursor = startCursor;
    }
}
