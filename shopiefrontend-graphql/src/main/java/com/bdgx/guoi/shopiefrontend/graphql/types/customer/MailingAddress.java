package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

public class MailingAddress {
    //  # Globally unique identifier.
    private final String id;//            id: ID!
    //
//            # Address line 1 (Street address/PO Box/Company name).
    private final String address1;//    address1: String
    //
//  # Address line 2 (Apartment/Suite/Unit/Building).
    private final String address2;//    address2: String
    //
//  # City/District/Suburb/Town/Village.
    private final String city;//            city: String
    //
//  # Company/Organization/Government.
    private final String company;//            company: String
    //
//  # State/County/Province/Region.
    private final String country;//            country: String
    //
//  # Two-letter country code.
//  #
//          # For example, US.
    private final String countryCode;//    countryCode: String
    //
//  # First name of the customer.
    private final String firstName;//            firstName: String
    //    formatted(withName: Boolean = false, withCompany: Boolean = true): [String!]!
//
//            # Comma-separated list of city, province, and country.
    private final String formattedArea;//            formattedArea: String
    //
//  # Last name of the customer.
    private final String lastName;//            lastName: String
    //
//  # Latitude coordinate of the customer address.
    private final Float latitude;//    latitude: Float
    //
//  # Longitude coordinate of the customer address.
    private final Float longitude;//    longitude: Float
    //
//  # Name of the customer, based on first name + last name.
    private final String name;//    name: String
    //
//  # Unique phone number for the customer.
//            #
//            # Formatted using E.164 standard. For example, _+16135551111_.
    private final String phone;//    phone: String
    //
//  # State/County/Province/Region.
    private final String province;//            province: String
    //
//  # Two-letter province or state code.
//  #
//          # For example, ON.
    private final String provinceCode;//    provinceCode: String
    //
//  # Zip/Postal Code.
    private final String zip;//    zip: String

    public MailingAddress() {
        this("id00", "address1", "address2", "city", "company", "country",
                "CN", "conan", "formattedArea", "chen",
                Float.valueOf(2.f), Float.valueOf(1.0f), "name", "phone", "province",
                "provinceCode", "zip");
    }

    public MailingAddress(String id, String address1, String address2, String city, String company, String country,
                          String countryCode, String firstName, String formattedArea, String lastName,
                          Float latitude, Float longitude, String name, String phone, String province, String provinceCode, String zip) {
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.company = company;
        this.country = country;
        this.countryCode = countryCode;
        this.firstName = firstName;
        this.formattedArea = formattedArea;
        this.lastName = lastName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.provinceCode = provinceCode;
        this.zip = zip;
    }
}
