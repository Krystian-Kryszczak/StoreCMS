package app.storecms.api.product;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;

@RestController
public class ProductController {
    ProductService productService;
    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }
    // -------------------------------------------------- //
    @GetMapping("/api/products/{id}")
    public Mono<Product> getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }
    @GetMapping("/api/products/search/{query}")
    public Flux<Product> searchProducts(@PathVariable String query, @RequestAttribute HashMap<String, String> attributes) {
        return productService.searchProducts(query, attributes);
    }
    @Secured("ADMIN")
    @PostMapping("/api/products/")
    public Mono<Boolean> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @Secured("ADMIN")
    @GetMapping("/api/products/{id}")
    public Mono<Boolean> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}