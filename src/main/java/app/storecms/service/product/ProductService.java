package app.storecms.service.product;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.storage.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    ProductRepository productRepo;
    public ProductService(@Autowired ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
    // -------------------------------------------------- //
    public Mono<Product> getProduct(String id) {
        return productRepo.findById(id);
    }
    public Mono<Boolean> addProduct(Product product) {
        return productRepo.save(product).map(r -> true).switchIfEmpty(Mono.just(false));
    }
    public Mono<Boolean> deleteProduct(String id) {
        return productRepo.deleteById(id).map(r -> true).switchIfEmpty(Mono.just(false));
    }
    public Flux<Product> searchProducts(String query, Map<String, String> attributes) { // TODO
        return productRepo.searchProductByNameIsNear(query);
    }
}