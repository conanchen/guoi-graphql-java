package com.github.conanchen.guoi.graphql.types;

import com.github.conanchen.guoi.graphql.types.address.Address;
import com.github.conanchen.guoi.graphql.types.attribute.Attribute;
import com.github.conanchen.guoi.graphql.types.image.Image;


public class ZGuoiCommonTypes {
    private Image image;//    image: Image
    private Address address;//    address: Address
    private Attribute attribute; // attribute: Attribute

    public ZGuoiCommonTypes(Image image, Address address,Attribute attribute) {
        this.image = image;
        this.address = address;
        this.attribute = attribute;
    }
}
