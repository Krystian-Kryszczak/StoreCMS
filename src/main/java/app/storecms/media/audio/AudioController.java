package app.storecms.media.audio;

import app.storecms.service.media.audio.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
public class AudioController {
    AudioService audioService;
    public AudioController(@Autowired AudioService audioService) {
        this.audioService = audioService;
    }
    // -------------------------------------------------- //
    @GetMapping("/media/audio/{id}")
    public Mono<byte[]> get(@PathVariable String id) {
        return audioService.getAudio(id).map(audio -> audio.getBinary().getData());
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @PostMapping("/media/audio")
    public Mono<String> add(@RequestParam("file") MultipartFile file) throws IOException {
        return audioService.addAudio(file);
    }
    // -------------------------------------------------- //
    @Secured("ADMIN")
    @DeleteMapping("/media/audio/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return audioService.deleteAudio(id);
    }
}