package app.storecms.storage.repository.media.video;

import app.storecms.model.media.video.Video;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends ReactiveCrudRepository<Video, String> {}