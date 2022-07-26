package app.storecms.api.category;

import app.storecms.model.shopping.basis.category.MainCategory;
import app.storecms.service.category.CategoryService;
import app.storecms.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CategoryController {
    ProductService productService;
    CategoryService categoryService;
    public CategoryController(@Autowired ProductService productService, @Autowired CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }
    // -------------------------------------------------- //
    @GetMapping("api/categories/")
    Mono<List<String>> getCategories() {
        return categoryService.getCategories();
    }
    @GetMapping("api/categories/{name}/")
    Mono<List<app.storecms.model.shopping.basis.product.Product>> searchInCategory(@PathVariable String name, Map<String,String> allParams) {
        return productService.searchProducts(name, allParams).collect(Collectors.toList());
    }
    @Secured("ADMIN")
    @PostMapping("api/categories/")
    Mono<Boolean> addCategory(@RequestBody MainCategory category) {
        return categoryService.addCategory(category);
    }
    @Secured("ADMIN")
    @DeleteMapping("api/categories/{name}")
    Mono<Boolean> deleteCategory(@PathVariable String name) {
        return categoryService.deleteCategory(name);
    }
}