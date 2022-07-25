package app.storecms.media.image;

import app.storecms.service.media.image.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class ImageController {
    ImageService imageService;
    public ImageController(@Autowired ImageService imageService) {
        this.imageService = imageService;
    }
    // -------------------------------------------------- //
    @GetMapping("/media/images/{id}")
    public Mono<byte[]> get(@PathVariable String id) {
        return imageService.getImage(id).map(image -> image.getBinary().getData());
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @PostMapping("/media/images/")
    public Mono<String> add(@RequestParam("file") MultipartFile file) throws IOException {
        return imageService.addImage(file);
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @DeleteMapping("/media/images/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return imageService.deleteImage(id);
    }
}