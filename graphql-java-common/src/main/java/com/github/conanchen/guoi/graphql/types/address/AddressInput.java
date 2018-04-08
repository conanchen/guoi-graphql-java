package com.github.conanchen.guoi.graphql.types.address;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressInput {
    private String address1;//    address1: String
    private String address2;//    address2: String
    private String city;//    city: String
    private String company;//    company: String
    private String country;//    country: String
    private String firstName;//    firstName: String
    private String lastName;//    lastName: String
    private String phone;//    phone: String
    private String province;//    province: String
    private String zip;//    zip: String
}
