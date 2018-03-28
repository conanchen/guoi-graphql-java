package com.bdgx.guoi.shopiefrontend.graphql.types.customer;

import com.bdgx.guoi.graphql.types.common.CurrencyCode;
import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.bdgx.guoi.shopiefrontend.graphql.types.cart.Cart;
import com.bdgx.guoi.shopiefrontend.graphql.types.cart.CartConnection;
import com.bdgx.guoi.shopiefrontend.graphql.types.cart.CartEdge;
import com.bdgx.guoi.shopiefrontend.graphql.types.checkout.Checkout;
import com.bdgx.guoi.shopiefrontend.graphql.types.checkout.CheckoutConnection;
import com.bdgx.guoi.shopiefrontend.graphql.types.checkout.CheckoutEdge;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.Order;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.OrderConnection;
import com.bdgx.guoi.shopiefrontend.graphql.types.order.OrderEdge;
import com.bdgx.guoi.shopiefrontend.graphql.types.shop.Shop;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.ArrayList;
import java.util.Date;

public class CustomerResolver implements GraphQLResolver<Customer> {

    public CustomerResolver() {
    }

    //    addresses(first: Int, after: String, last: Int, before: String, reverse: Boolean = false): MailingAddressConnection!
    public MailingAddressConnection addresses(
            Customer customer,
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse

    ) {
        return new MailingAddressConnection(new ArrayList<MailingAddressEdge>() {{
            add(new MailingAddressEdge("cursor1", new MailingAddress()));
            add(new MailingAddressEdge("cursor2", new MailingAddress()));
            add(new MailingAddressEdge("cursor3", new MailingAddress()));
        }}, new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }

//  # The orders associated with the customer.
    public OrderConnection orders(
            Customer customer,
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse,
//            #sortKey: OrderSortKeys = ID
//
//            # Supported filter parameters:
//            #  - `processed_at`
            String query
    ){
        Shop shop = new Shop("id001","shopname","descriptoin");
       Order o1= new Order("orderid1",shop, CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",new Date(),
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

       Order o2= new Order("orderid2",shop, CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",new Date(),
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

       Order o3= new Order("orderid3",shop, CurrencyCode.CNY,"customerLocale",
                "conan8chan@yahoo.com",Integer.valueOf(232),"13423423423",new Date(),
                new MailingAddress(),Float.valueOf(11.2f),Float.valueOf(112.0f),
                Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f));

        return new OrderConnection(new ArrayList<OrderEdge>(){{
            add(new OrderEdge("cursor",o1));
            add(new OrderEdge("cursor",o2));
            add(new OrderEdge("cursor",o3));

        }},new PageInfo("end",Boolean.FALSE,Boolean.FALSE,"start"));
    }

//  # The carts associated with the customer.
    public CartConnection carts(
            Customer customer,
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse,
//            #sortKey: CartSortKeys = ID
//
//            # Supported filter parameters:
//            #  - `processed_at`
            String query
    ){
       Cart o1= new Cart("cart1",new Shop("shopid1","shopid1name","shopdescription"),Float.valueOf(22.0f));
       Cart o2= new Cart("cart2",new Shop("shopid2","shopid2name","shopdescription"),Float.valueOf(22.0f));
       Cart o3= new Cart("cart3",new Shop("shopid3","shopid3name","shopdescription"),Float.valueOf(22.0f));



        return new CartConnection(new ArrayList<CartEdge>(){{
            add(new CartEdge("cursor",o1));
            add(new CartEdge("cursor",o2));
            add(new CartEdge("cursor",o3));

        }},new PageInfo("end",Boolean.FALSE,Boolean.FALSE,"start"));
    }


    //  # The carts associated with the customer.
    public CheckoutConnection checkouts(
            Customer customer,
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last,

            Boolean reverse,
//            #sortKey: CartSortKeys = ID
//
//            # Supported filter parameters:
//            #  - `processed_at`
            String query
    ){
        Shop shop1 = new Shop("shop1","shopname1","desc1");
        Checkout o1= new Checkout("checkoutid1",shop1,new Date(),new Date(),CurrencyCode.CNY,null,"conanchen@yao.com","anote"
        ,null,Boolean.FALSE,null,Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f),new Date());

        Checkout o2= new Checkout("checkoutid2",shop1,new Date(),new Date(),CurrencyCode.CNY,null,"conanchen@yao.com","anote"
                ,null,Boolean.FALSE,null,Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f),new Date());
        Checkout o3= new Checkout("checkoutid3",shop1,new Date(),new Date(),CurrencyCode.CNY,null,"conanchen@yao.com","anote"
                ,null,Boolean.FALSE,null,Float.valueOf(22.0f),Float.valueOf(22.0f),Float.valueOf(22.0f),new Date());



        return new CheckoutConnection(new ArrayList<CheckoutEdge>(){{
            add(new CheckoutEdge("cursor",o1));
            add(new CheckoutEdge("cursor",o2));
            add(new CheckoutEdge("cursor",o3));

        }},new PageInfo("end",Boolean.FALSE,Boolean.FALSE,"start"));
    }

}
