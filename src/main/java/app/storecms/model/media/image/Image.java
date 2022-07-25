package app.storecms.model.media.image;

import app.storecms.model.media.Media;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "image")
public class Image extends Media {
    public Image(Binary binary) {
        super(binary);
    }
}