package com.bdgx.guoi.shopiefrontend.graphql;

import com.bdgx.guoi.shopiefrontend.graphql.type.*;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
public class Query implements GraphQLQueryResolver {

    public Query() {

    }

    public Person person(String phoneno) {
        return new Person("personid1", "conan", "chen", "conan8chan@yahoo.com");
    }

    public User viewer() {
        return new User("id1", "login", "conan", "conan8chan@yahoo.com");
    }

    public CatalogConnection catalogs(

//    # Returns the elements in the list that come after the specified global ID.
            String after,//            after: String
//
//            # Returns the elements in the list that come before the specified global ID.
            String before,//            before: String
//
//            # Returns the first _n_ elements from the list.
            Integer first,//            first: Int
//
//            # Returns the last _n_ elements from the list.
            Integer last//            last: Int
//
//            # Ordering options for repositories returned from the connection
//            # orderBy: RepositoryOrder

    ) {
        Catalog catalog1 = new Catalog("catalogid1", "catalogtitle1", null);
        Catalog catalog2 = new Catalog("catalogid2", "catalogtitle2", catalog1);
        Catalog catalog3 = new Catalog("catalogid3", "catalogtitle3", catalog1);
        return new CatalogConnection(new ArrayList<CatalogEdge>() {{
            add(new CatalogEdge("cursor", catalog1));
            add(new CatalogEdge("cursor", catalog2));
            add(new CatalogEdge("cursor", catalog3));
        }}, new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }


    //  # List of products in the catalog.
    public ProductConnection products(
            //# Returns the elements in the list that come after the specified global ID.
            String after,

            //# Returns the elements in the list that come before the specified global ID.
            String before,

            // # Returns the first _n_ elements from the list.
            Integer first,

            //  # Returns the last _n_ elements from the list.
            Integer last

            // Boolean reverse
    ) {
        return new ProductConnection(new ArrayList<ProductEdge>() {{
            add(new ProductEdge("cursor", new Product("productid1", "<b>description html 1</b>", "productType1", null, "productTitle1", "productVender1")));
            add(new ProductEdge("cursor", new Product("productid2", "<b>description html 2</b>", "productType2", null, "productTitle2", "productVender2")));
            add(new ProductEdge("cursor", new Product("productid3", "<b>description html 3</b>", "productType3", null, "productTitle3", "productVender2")));
        }}, new PageInfo("end", Boolean.FALSE, Boolean.FALSE, "start"));
    }

}
