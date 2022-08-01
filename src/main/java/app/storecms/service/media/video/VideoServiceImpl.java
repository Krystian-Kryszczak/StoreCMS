package app.storecms.service.media.video;

import app.storecms.model.media.Media;
import app.storecms.model.media.video.Video;
import app.storecms.storage.repository.media.video.VideoRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Service
public class VideoServiceImpl implements VideoService {
    VideoRepository videoRepo;
    public VideoServiceImpl(@Autowired VideoRepository videoRepo) {
        this.videoRepo = videoRepo;
    }
    // -------------------------------------------------- //
    public Mono<Video> getVideo(String id) {
        return videoRepo.findById(id);
    }
    public Mono<String> addVideo(Video video) {
        return videoRepo.save(video).map(Media::getId);
    }
    public Mono<String> addVideo(MultipartFile file) throws IOException {
        return videoRepo.save(new Video(new Binary(BsonBinarySubType.BINARY, file.getBytes()))).map(Media::getId);
    }
    public Mono<Void> deleteVideo(String id) {
        return videoRepo.deleteById(id);
    }
}