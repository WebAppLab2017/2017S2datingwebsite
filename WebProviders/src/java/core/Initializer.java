package core;

import com.google.gson.Gson;
import static core.PhoneAPI.JSON_STRING;
import java.util.List;

/**
 *
 * @author IU-CSE Team
 */
public class Initializer {

    private static final Gson GSON = new Gson();

    public static List<Product> initialize() {
        Products products = (Products) GSON.fromJson(JSON_STRING, Products.class);

        return products.getProducts();
    }

    public static List<Product> getLaptops() {
        Products products = (Products) GSON.fromJson(LaptopAPI.LAPTOP_JSON_STRING, Products.class);

        return products.getProducts();
    }

    public static List<Product> getTablets() {
        Products products = (Products) GSON.fromJson(TabletAPI.TABLET_JSON_STRING, Products.class);

        return products.getProducts();
    }

    public static List<Product> getTelevisions() {
        Products products = (Products) GSON.fromJson(TelevisionAPI.TELEVISION_JSON_STRING, Products.class);

        return products.getProducts();
    }

}
