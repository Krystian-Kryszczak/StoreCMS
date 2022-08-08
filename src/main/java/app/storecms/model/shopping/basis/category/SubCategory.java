package app.storecms.model.shopping.basis.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SubCategory { // TODO updating in database
    @Id
    @Getter
    final String id;
    @Getter
    final String name;
    final List<String> products;
    public SubCategory(String id, String name) {
        this.id = id;
        this.name = name;
        this.products = new ArrayList<>();
    }
    public Flux<String> getProductsIds() {
        return Flux.fromIterable(products);
    }
    public Mono<Boolean> addProduct(Category category) {
        return Mono.just(products.add(category.getId()));
    }
    public Mono<Boolean> removeProduct(Category category) {
        return Mono.just(products.remove(category.getId()));
    }
}