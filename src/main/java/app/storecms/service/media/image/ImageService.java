package app.storecms.service.media.image;

import app.storecms.model.media.Media;
import app.storecms.model.media.image.Image;
import app.storecms.storage.repository.media.image.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class ImageService {
    private ImageRepository imageRepo;
    public ImageService(@Autowired ImageRepository imageRepo) {
        this.imageRepo = imageRepo;
    }
    public Mono<Image> getImage(String id) {
        return imageRepo.findById(id);
    }
    public Mono<String> addImage(Image image) {
        return imageRepo.save(image).map(Media::getId);
    }
    public Mono<String> addImage(MultipartFile file) throws IOException {
        return imageRepo.save(new Image(new Binary(BsonBinarySubType.BINARY, file.getBytes()))).map(Media::getId);
    }
    public Mono<Void> deleteImage(String id) {
        return imageRepo.deleteById(id);
    }
}