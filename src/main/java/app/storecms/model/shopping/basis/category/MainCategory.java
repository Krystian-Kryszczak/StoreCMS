package app.storecms.model.shopping.basis.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Document(collation = "categories")
public class MainCategory {
    // TODO updating in database
    @Id @Getter
    final String id;
    @Getter
    final String name;
    final List<Category> categories;
    public MainCategory(String id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();
    }
    public Flux<Category> getCategories() {
        return Flux.fromIterable(categories);
    }
    public Mono<Boolean> addCategory(Category category) {
        return Mono.just(categories.add(category));
    }
    public Mono<Boolean> removeCategory(Category category) {
        return Mono.just(categories.remove(category));
    }
}