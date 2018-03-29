package com.bdgx.guoi.shopiefrontend.graphql.types.catalog;

import com.bdgx.guoi.graphql.types.common.CropRegion;
import com.bdgx.guoi.graphql.types.common.Image;
import com.bdgx.guoi.shopiefrontend.graphql.types.PageInfo;
import com.coxautodev.graphql.tools.GraphQLResolver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class CatalogResolver implements GraphQLResolver<Catalog> {

    public CatalogResolver( ) {

    }


    //  # List of products in the catalog.
    public ProductConnection products(Catalog catalog,
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


    public Image image(
            Catalog catalog,
            //    #Image width in pixels between 1 and 2048
            Integer maxWidth,//            maxWidth: Int

            //            # Image height in pixels between 1 and 2048
            Integer maxHeight,//            maxHeight: Int

            //            # If specified, crop the image keeping the specified region
            CropRegion crop,//            crop: CropRegion

            //            # Image size multiplier retina displays. Must be between 1 and 3
            Integer scale//            scale: Int = 1
    ) {
        throw new NotImplementedException();
    }
}
