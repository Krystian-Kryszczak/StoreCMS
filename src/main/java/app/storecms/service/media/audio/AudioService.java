package app.storecms.service.media.audio;

import app.storecms.model.media.audio.Audio;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface AudioService {
    Mono<Audio> getAudio(String id);
    Mono<String> addAudio(Audio audio);
    Mono<String> addAudio(MultipartFile file) throws IOException;
    Mono<Void> deleteAudio(String id);
}