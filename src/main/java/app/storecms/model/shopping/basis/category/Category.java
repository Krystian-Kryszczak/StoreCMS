package app.storecms.model.shopping.basis.category;

import app.storecms.model.shopping.Folder;
import app.storecms.model.shopping.basis.product.Product;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Getter
@Document(collation = "categories")
public class Category implements Folder<Product> {
    @Id
    String id;
    String name;
    @Override
    public Mono<Product> addItem(Product item) {
        return null;
    }
    @Override
    public Flux<Product> getItems() {
        return null;
    }
    @Override
    public Mono<Product> removeItem(Product item) {
        return null;
    }
}