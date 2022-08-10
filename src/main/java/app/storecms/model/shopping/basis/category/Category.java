package app.storecms.model.shopping.basis.category;

import app.storecms.model.shopping.basis.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Category {
    @Getter
    private final MainCategory mainCategory;
    @Getter
    final String name;
    final List<String> productList;
    final List<SubCategory> subCategories;
    public Category(String name, MainCategory mainCategory) {
        this.name = name;
        this.mainCategory = mainCategory;
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
    public Flux<SubCategory> getSubCategoriesIds() {
        return Flux.fromIterable(subCategories);
    }
    public Mono<Boolean> addSubCategory(SubCategory category) {
        return Mono.just(subCategories.add(category)).then(update());
    }
    public Mono<Boolean> removeSubCategory(SubCategory category) {
        return Mono.just(subCategories.remove(category)).then(update());
    }
    Mono<Boolean> update() {
        return mainCategory.update();
    }
}