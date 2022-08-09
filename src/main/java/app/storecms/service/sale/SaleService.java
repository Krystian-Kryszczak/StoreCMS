package app.storecms.service.sale;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.model.shopping.utils.sale.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleService {
    Flux<Sale> getSales();
    Flux<Sale> getSales(int limit);
    Mono<Sale> createSale(String discountCode, List<Product> productList, LocalDateTime expiryDateTime);
    Mono<Sale> getSaleByDiscountCode(String discountCode);
    Mono<Sale> getSale(String saleId);
    Mono<Void> deleteSale(String saleId);
    Mono<Sale> updateSale(Sale sale);
}