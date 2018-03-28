package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.bdgx.guoi.graphql.types.common.WeightUnit;

public class ProductVariant {
    //  # Globally unique identifier.
    private final String id;//            id: ID!
    //
//            # Indicates if the product variant is in stock.
    private final Boolean available;//    available: Boolean
    //
//  # Indicates if the product variant is available for sale.
    private final Boolean availableForSale;//            availableForSale: Boolean!
    //
//
//
//  # The product variant’s price.
    private final Float price;//    price: Money!
    //
//            # The product object that the product variant belongs to.
    private final Product product;//            product: Product!
    //
//            # The SKU (Stock Keeping Unit) associated with the variant.
    private final String sku;//    sku: String
    //
//  # The product variant’s title.
    private final String title;//    title: String!
    //
//            # The weight of the product variant in the unit system specified with `weight_unit`.
    private final Float weight;//    weight: Float
    //
//  # Unit of measurement for weight.
    private final WeightUnit weightUnit;//            weightUnit: WeightUnit!

    public ProductVariant(String id, Boolean available, Boolean availableForSale, Float price, Product product, String sku, String title, Float weight, WeightUnit weightUnit) {
        this.id = id;
        this.available = available;
        this.availableForSale = availableForSale;
        this.price = price;
        this.product = product;
        this.sku = sku;
        this.title = title;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }
}
