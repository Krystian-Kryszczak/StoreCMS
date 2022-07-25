package app.storecms.model.media.audio;

import app.storecms.model.media.Media;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "audio")
public class Audio extends Media {
    public Audio(Binary binary) {
        super(binary);
    }
}