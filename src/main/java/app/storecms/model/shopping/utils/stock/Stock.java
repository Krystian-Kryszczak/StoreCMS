package app.storecms.model.shopping.utils.stock;

import app.storecms.model.shopping.Folder;
import app.storecms.model.shopping.basis.product.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Stock implements Folder<Product> { // Favorite list
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