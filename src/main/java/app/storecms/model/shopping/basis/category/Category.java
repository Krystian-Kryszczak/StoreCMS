package app.storecms.model.shopping.basis.category;

import app.storecms.model.shopping.basis.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Category {
    // TODO updating in database
    @Id @Getter
    final String id;
    @Getter
    final String name;
    final List<String> productList;
    final List<String> subCategories;
    public Category(String id, String name) {
        this.id = id;
        this.name = name;
        this.productList = new ArrayList<>();
        this.subCategories = new ArrayList<>();
    }
    public Flux<String> getProductsIds() {
        return Flux.fromIterable(productList);
    }
    public Mono<Boolean> addProduct(Product item) {
        return Mono.just(productList.add(item.getId()));
    }
    public Mono<Boolean> removeProduct(Product item) {
        return Mono.just(productList.remove(item.getId()));
    }
    // ---------------------------------------------------------------------------------------------------- //
    public Flux<String> getSubCategoriesIds() {
        return Flux.fromIterable(subCategories);
    }
    public Mono<Boolean> addSubCategory(SubCategory category) {
        return Mono.just(subCategories.add(category.getId()));
    }
    public Mono<Boolean> removeSubCategory(SubCategory category) {
        return Mono.just(subCategories.remove(category.getId()));
    }
}