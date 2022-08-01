package app.storecms.storage.repository.product;

import app.storecms.model.shopping.basis.product.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
    // ----------------------------------------------------------------------------------------------------------------------------- //
    Flux<Product> searchProductByNameIsNear(String value);
    // ----------------------------------------------------------------------------------------------------------------------------- //
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeries(String value, String category, String manufacturer, String series);
    // ----------------------------------------------------------------------------------------------------------------------------- //
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByName(String value, String category, String manufacturer, String series);
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByNameDesc(String value, String category, String manufacturer, String series);
    // ----------------------------------------------------------------------------------------------------------------------------- //
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByManufacturer(String value, String category, String manufacturer, String series);
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByManufacturerDesc(String value, String category, String manufacturer, String series);
    // ----------------------------------------------------------------------------------------------------------------------------- //
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByPrice(String value, String category, String manufacturer, String series);
    Flux<Product> searchProductByNameIsNearAndCategoryAndManufacturerAndSeriesOrderByPriceDesc(String value, String category, String manufacturer, String series);
    // ----------------------------------------------------------------------------------------------------------------------------- //
}