package app.storecms.model.shopping.basis.product;

import app.storecms.service.product.ProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

@Getter
@AllArgsConstructor
public class ProductStack {
    @Autowired ProductService productService;
    final String productId;
    @Setter int amount;
    Mono<Product> getProduct() {
        return productService.getProduct(productId);
    }
    public int add(int value) {
        amount += value;
        return amount;
    }
}