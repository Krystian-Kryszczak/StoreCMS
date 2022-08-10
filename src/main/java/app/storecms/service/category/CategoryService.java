package app.storecms.service.category;

import app.storecms.model.shopping.basis.category.MainCategory;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryService {
    Mono<List<String>> getCategories();
    Mono<MainCategory> getCategory(String name);
    Mono<Boolean> addCategory(MainCategory category);
    Mono<Boolean> deleteCategory(String name);
    Mono<Boolean> updateCategory(MainCategory category);
}