package app.storecms.service.category;

import app.storecms.model.shopping.basis.category.Category;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryService {
    Mono<List<String>> getCategories();
    Mono<Category> getCategory(String name);
    Mono<Boolean> addCategory(Category category);
    Mono<Boolean> deleteCategory(String name);
}