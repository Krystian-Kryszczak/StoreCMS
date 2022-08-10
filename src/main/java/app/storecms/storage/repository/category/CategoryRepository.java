package app.storecms.storage.repository.category;

import app.storecms.model.shopping.basis.category.MainCategory;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<MainCategory, String> {
    Mono<MainCategory> findByName(String name);
    Mono<Boolean> deleteByName(String name);
}