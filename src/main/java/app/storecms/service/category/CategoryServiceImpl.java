package app.storecms.service.category;

import app.storecms.model.shopping.basis.category.MainCategory;
import app.storecms.storage.repository.category.CategoryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepo;
    public CategoryServiceImpl(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }
    // -------------------------------------------------- //
    public Mono<List<String>> getCategories() {
        return categoryRepo.findAll().map(MainCategory::getName).collect(Collectors.toList());
    }
    public Mono<MainCategory> getCategory(String name) {
        return categoryRepo.findByName(name);
    }
    public Mono<Boolean> addCategory(MainCategory category) {
        return categoryRepo.save(category).thenReturn(true).switchIfEmpty(Mono.just(false));
    }
    public Mono<Boolean> deleteCategory(String name) {
        return categoryRepo.deleteByName(name).thenReturn(true).switchIfEmpty(Mono.just(false));
    }
    public Mono<Boolean> updateCategory(MainCategory category) {
        return categoryRepo.save(category).thenReturn(true).onErrorReturn(false);
    }
}