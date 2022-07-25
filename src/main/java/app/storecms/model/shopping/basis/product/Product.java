package app.storecms.model.shopping.basis.product;

import app.storecms.model.shopping.basis.price.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collation = "products")
public class Product {
    @Id
    String id;
    String sku;
    String ean;
    String name;
    String series;
    String ref_num;
    String manufacturer;
    boolean is_vendor; // Czy produkt jest od dostawcy zewnętrznego?
    boolean is_wire; // Czy produkt jest kablem?
    String image;
    String category;
    Price price;

    String providerLabel;
    // TODO
}