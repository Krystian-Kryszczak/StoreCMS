package app.storecms.model.shopping.basis.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "users")
public class User {
    @Id
    private String id;
    private String email;
}