package app.storecms.model.shopping.basis.category;

import app.storecms.model.shopping.basis.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SubCategory {
    private final Category category;
    @Getter
    final String name;
    final List<String> products;
    public SubCategory(String name, Category category) {
        this.name = name;
        this.category = category;
        this.products = new ArrayList<>();
    }
    public Flux<String> getProductsIds() {
        return Flux.fromIterable(products);
    }
    public Mono<Boolean> addProduct(Product product) {
        return Mono.just(products.add(product.getId())).then(update());
    }
    public Mono<Boolean> removeProduct(Product product) {
        return Mono.just(products.remove(product.getId())).then(update());
    }
    Mono<Boolean> update() {
        return category.update();
    }
}