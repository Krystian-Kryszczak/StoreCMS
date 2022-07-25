package app.storecms.storage.repository.media.audio;

import app.storecms.model.media.audio.Audio;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioRepository extends ReactiveCrudRepository<Audio, String> {}