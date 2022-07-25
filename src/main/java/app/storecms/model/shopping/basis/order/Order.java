package app.storecms.model.shopping.basis.order;

import app.storecms.model.shopping.Folder;
import app.storecms.model.shopping.basis.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
@Document(collation = "orders")
public class Order implements Folder<Product> {
    @Id
    String id;
    String ownerName;
    // TODO require ownerId

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