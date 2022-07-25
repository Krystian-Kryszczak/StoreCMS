package app.storecms.storage.repository.product;

import app.storecms.model.shopping.basis.product.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
    Flux<Product> searchProductByNameIsNear(String value);
}