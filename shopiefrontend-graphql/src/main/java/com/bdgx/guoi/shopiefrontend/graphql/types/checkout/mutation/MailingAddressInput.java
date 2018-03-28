package com.bdgx.guoi.shopiefrontend.graphql.types.checkout.mutation;

public class MailingAddressInput {
    private final String address1;//    address1: String
    private final String address2;//    address2: String
    private final String city;//    city: String
    private final String company;//    company: String
    private final String country;//    country: String
    private final String firstName;//    firstName: String
    private final String lastName;//    lastName: String
    private final String phone;//    phone: String
    private final String province;//    province: String
    private final String zip;//    zip: String

    public MailingAddressInput(String address1, String address2, String city, String company,
                               String country, String firstName, String lastName, String phone,
                               String province, String zip) {
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.company = company;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.province = province;
        this.zip = zip;
    }
}
