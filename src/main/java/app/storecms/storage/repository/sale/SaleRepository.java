package app.storecms.storage.repository.sale;

import app.storecms.model.shopping.utils.sale.Sale;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface SaleRepository extends ReactiveCrudRepository<Sale, String> {
    Mono<Sale> findByDiscountCode(String discountCode);
}