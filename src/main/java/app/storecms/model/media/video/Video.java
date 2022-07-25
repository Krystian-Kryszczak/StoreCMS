package app.storecms.model.media.video;

import app.storecms.model.media.Media;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "video")
public class Video extends Media {
    public Video(Binary binary) {
        super(binary);
    }
}