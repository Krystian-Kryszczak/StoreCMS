package app.storecms.model.shopping.utils.sale;

import app.storecms.model.shopping.basis.product.Product;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Document(collation = "sales")
public class Sale {
    // TODO
    public Mono<Product> addItem(Product item) {
        return null;
    }
    public Flux<Product> getItems() {
        return null;
    }
    public Mono<Product> removeItem(Product item) {
        return null;
    }
}