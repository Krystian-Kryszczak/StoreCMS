package app.storecms.model.media;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

@Data
public abstract class Media {
    @Id
    private String id;
    private Binary binary;
    // -------------------------------------------------- //
    public Media(Binary binary) {
        this.binary = binary;
    }
}