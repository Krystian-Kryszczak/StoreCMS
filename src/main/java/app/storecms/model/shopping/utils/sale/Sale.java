package app.storecms.model.shopping.utils.sale;

import app.storecms.model.shopping.Folder;
import app.storecms.model.shopping.basis.product.Product;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Document(collation = "sales")
public class Sale implements Folder<Product> {
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