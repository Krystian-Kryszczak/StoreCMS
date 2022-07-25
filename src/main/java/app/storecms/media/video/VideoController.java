package app.storecms.media.video;

import app.storecms.service.media.video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class VideoController {
    VideoService videoService;
    public VideoController(@Autowired VideoService videoService) {
        this.videoService = videoService;
    }
    // -------------------------------------------------- //
    @GetMapping("/media/videos/{id}")
    public Mono<byte[]> get(@PathVariable String id) {
        return videoService.getVideo(id).map(video -> video.getBinary().getData());
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @PostMapping("/media/videos")
    public Mono<String> add(@RequestParam("file") MultipartFile file) throws IOException {
        return videoService.addVideo(file);
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @DeleteMapping("/media/videos/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return videoService.deleteVideo(id);
    }
}