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
public class ZGuoiCommonTypes {
    private Image image;//    image: Image
    private Address address;//    address: Address

    public ZGuoiCommonTypes(Image image, Address address) {
        this.image = image;
        this.address = address;
    }
}
