package app.storecms.service.product;

import app.storecms.model.shopping.basis.product.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface ProductService {
    Mono<Product> getProduct(String id);
    Mono<Boolean> addProduct(Product product);
    Mono<Boolean> deleteProduct(String id);
    Flux<Product> searchProducts(String query, Map<String, String> parameters);
}