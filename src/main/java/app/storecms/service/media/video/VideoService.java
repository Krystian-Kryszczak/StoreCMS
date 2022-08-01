package app.storecms.service.media.video;

import app.storecms.model.media.video.Video;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface VideoService {
    Mono<Video> getVideo(String id);
    Mono<String> addVideo(Video video);
    Mono<String> addVideo(MultipartFile file) throws IOException;
    Mono<Void> deleteVideo(String id);
}