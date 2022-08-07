package app.storecms.model.shopping.basis.product;

import app.storecms.model.shopping.basis.price.Price;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Value
@AllArgsConstructor
@Document(collation = "products")
public class Product { // TODO updating in database
    @Id
    String id;
    String sku;
    String ean;
    String name;
    String manufacturer;
    @Setter
    @NonFinal
    String mainImage;
    List<String> images;
    String category;
    Price price;
    String providerLabel;
    Specification specification;
    public boolean addImage(String imageUrl) {
        return images.add(imageUrl);
    }
    public boolean removeImage(String imageUrl) {
        return images.remove(imageUrl);
    }
}