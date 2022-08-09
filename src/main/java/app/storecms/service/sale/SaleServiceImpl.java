package app.storecms.service.sale;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.model.shopping.utils.sale.Sale;
import app.storecms.storage.repository.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    SaleRepository saleRepository;
    public SaleServiceImpl(@Autowired SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    @Override
    public Flux<Sale> getSales() {
        return saleRepository.findAll();
    }
    @Override
    public Flux<Sale> getSales(int limit) {
        return saleRepository.findAll().limitRate(limit);
    }
    @Override
    public Mono<Sale> createSale(String discountCode, List<Product> productList, LocalDateTime expiryDateTime) {
        return null;
    }
    @Override
    public Mono<Sale> getSaleByDiscountCode(String discountCode) {
        return saleRepository.findByDiscountCode(discountCode);
    }
    @Override
    public Mono<Sale> getSale(String saleId) {
        return saleRepository.findById(saleId);
    }
    @Override
    public Mono<Void> deleteSale(String saleId) {
        return saleRepository.deleteById(saleId);
    }
    @Override
    public Mono<Sale> updateSale(Sale sale) {
        return saleRepository.save(sale);
    }
}