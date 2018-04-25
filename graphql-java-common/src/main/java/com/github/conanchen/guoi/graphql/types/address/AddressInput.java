package com.github.conanchen.guoi.graphql.types.address;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AddressInput {
    //
//            # Address line 1 (Street address/PO Box/Company name).
    private String address1;//    address1: String
    //
//  # Address line 2 (Apartment/Suite/Unit/Building).
    private String address2;//    address2: String
    //
//  # City/District/Suburb/Town/Village.
    private String city;//            city: String
    //
//  # Company/Organization/Government.
    private String company;//            company: String
    //
//  # State/County/Province/Region.
    private String country;//            country: String
    //
//  # Two-letter country code.
//  #
//          # For example, US.
    private String countryCode;//    countryCode: String
    //
//  # First name of the customer.
    private String firstName;//            firstName: String
    //    formatted(withName: Boolean = false, withCompany: Boolean = true): [String!]!
//
//            # Comma-separated list of city, province, and country.
    private String formattedArea;//            formattedArea: String
    //
//  # Last name of the customer.
    private String lastName;//            lastName: String
    //
//  # Latitude coordinate of the customer address.
    private Float latitude;//    latitude: Float
    //
//  # Longitude coordinate of the customer address.
    private Float longitude;//    longitude: Float
    //
//  # Name of the customer, based on first name + last name.
    private String name;//    name: String
    //
//  # Unique phone number for the customer.
//            #
//            # Formatted using E.164 standard. For example, _+16135551111_.
    private String phone;//    phone: String
    //
//  # State/County/Province/Region.
    private String province;//            province: String
    //
//  # Two-letter province or state code.
//  #
//          # For example, ON.
    private String provinceCode;//    provinceCode: String
    //
//  # Zip/Postal Code.
    private String zip;//    zip: String

//  # Position lng
    private Float lng;//    lng: Float

//  # Position lat
    private Float lat;//    lat: Float
}
