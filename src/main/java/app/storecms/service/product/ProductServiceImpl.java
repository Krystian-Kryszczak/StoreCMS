package app.storecms.service.product;

import app.storecms.model.shopping.basis.product.Product;
import app.storecms.model.shopping.basis.sorting.OrderBy;
import app.storecms.storage.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepo;
    public ProductServiceImpl(@Autowired ProductRepository productRepo) {
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
    public Flux<Product> searchProducts(String query, Map<String, String> parameters) {
        if (parameters.isEmpty()) {
            return productRepo.searchProductByNameIsNear(query);
        } else if (parameters.get("category")!=null || parameters.get("manufacturer")!=null || parameters.get("series")!=null) {
            if (parameters.get("orderBy")==null && !parameters.get("orderBy").isBlank()) {
                return productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeries(
                        query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series")
                );
            }
            try {
                OrderBy orderBy = OrderBy.valueOf(parameters.get("orderBy").toUpperCase());
                return switch (orderBy) {
                    case ASC_NAME -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByName(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    case DESC_NAME -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByNameDesc(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    case ASC_MANUFACTURER -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByManufacturer(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    case DESC_MANUFACTURER -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByManufacturerDesc(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    case ASC_PRICE -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByPrice(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    case DESC_PRICE -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByPriceDesc(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                    default -> productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeries(
                            query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series"));
                };
            } catch (IllegalArgumentException ignored) {
                return productRepo.searchProductByNameIsNearAndCategoryAndManufacturerAndSeries(
                        query, parameters.get("category"), parameters.get("manufacturer"), parameters.get("series")
                );
            }
        }
        return Flux.empty();
    }
}