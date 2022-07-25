package app.storecms.storage.repository.category;

import app.storecms.model.shopping.basis.category.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, String> {
    Mono<Category> findByName(String name);
    Mono<Boolean> deleteByName(String name);
}