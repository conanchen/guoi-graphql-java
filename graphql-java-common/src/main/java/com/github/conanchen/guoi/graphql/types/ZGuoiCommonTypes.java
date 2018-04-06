package com.github.conanchen.guoi.graphql.types;

import com.github.conanchen.guoi.graphql.types.address.Address;
import com.github.conanchen.guoi.graphql.types.image.Image;


public class ZGuoiCommonTypes {
    private Image image;//    image: Image
    private Address address;//    address: Address

    public ZGuoiCommonTypes(Image image, Address address) {
        this.image = image;
        this.address = address;
    }
}
