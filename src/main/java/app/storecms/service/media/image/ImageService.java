package app.storecms.service.media.image;

import app.storecms.model.media.image.Image;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface ImageService {
    Mono<Image> getImage(String id);
    Mono<String> addImage(Image image);
    Mono<String> addImage(MultipartFile file) throws IOException;
    Mono<Void> deleteImage(String id);
}