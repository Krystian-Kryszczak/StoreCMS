package app.storecms.service.media.audio;

import app.storecms.model.media.Media;
import app.storecms.model.media.audio.Audio;
import app.storecms.storage.repository.media.audio.AudioRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class AudioService {
    private AudioRepository audioRepo;
    public AudioService(@Autowired AudioRepository audioRepo) {
        this.audioRepo = audioRepo;
    }
    public Mono<Audio> getAudio(String id) {
        return audioRepo.findById(id);
    }
    public Mono<String> addAudio(Audio audio) {
        return audioRepo.save(audio).map(Media::getId);
    }
    public Mono<String> addAudio(MultipartFile file) throws IOException {
        return audioRepo.save(new Audio(new Binary(BsonBinarySubType.BINARY, file.getBytes()))).map(Media::getId);
    }
    public Mono<Void> deleteAudio(String id) {
        return audioRepo.deleteById(id);
    }
}