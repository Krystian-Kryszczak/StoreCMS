package app.storecms.model.shopping.utils.sale;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.service.product.ProductService;
import app.storecms.service.sale.SaleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Value
@Getter
@AllArgsConstructor
@Document(collation = "sales")
public class Sale { // TODO auto-delete
    @Autowired @NonFinal
    SaleService saleService;
    @Autowired @NonFinal
    ProductService productService;
    @Id
    String id;
    String discountCode;
    List<String> productIdsList;
    LocalDateTime expiryDateTime;
    public Sale(String discountCode, List<String> productIdsList, LocalDateTime expiryDateTime) {
        this.id = null;
        this.discountCode = discountCode;
        this.productIdsList = productIdsList;
        this.expiryDateTime = expiryDateTime;
    }
    public Mono<Boolean> addItem(Product product) {
        boolean result = productIdsList.add(product.getId());
        return update().thenReturn(result);
    }
    public Flux<Product> getItems() {
        return getItemsIds().concatMap(productId -> Flux.from(productService.getProduct(productId)));
    }
    public Flux<String> getItemsIds() {
        return Flux.fromIterable(productIdsList);
    }
    public Mono<Product> removeItem(Product product) {
        return removeItemById(product.getId()).thenReturn(product);
    }
    public Mono<Boolean> removeItemById(String productId) {
        boolean result = productIdsList.remove(productId);
        return update().thenReturn(result);
    }
    private Mono<Sale> update() {
        return saleService.updateSale(this);
    }
}