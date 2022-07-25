package app.storecms.model.shopping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface Folder<T> {
    Mono<T> addItem(T item);
    Flux<T> getItems();
    Mono<T> removeItem(T item);
}