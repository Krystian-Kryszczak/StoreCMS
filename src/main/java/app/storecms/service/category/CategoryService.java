package app.storecms.service.category;

import app.storecms.model.shopping.basis.category.Category;
import app.storecms.storage.repository.category.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    CategoryRepository categoryRepo;
    public CategoryService(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    // -------------------------------------------------- //
    public Mono<List<String>> getCategories() {
        return categoryRepo.findAll().map(Category::getName).collect(Collectors.toList());
    }
    public Mono<Category> getCategory(String name) {
        return categoryRepo.findByName(name);
    }
    public Mono<Boolean> addCategory(Category category) {
        return categoryRepo.save(category).map(r -> true).switchIfEmpty(Mono.just(false));
    }
    public Mono<Boolean> deleteCategory(String name) {
        return categoryRepo.deleteByName(name).map(r -> true).switchIfEmpty(Mono.just(false));
    }
}