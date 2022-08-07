package app.storecms.model.shopping.basis.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Specification {
    @Getter
    final Map<String, String> parameters;
    public Specification() {
        this.parameters = new HashMap<>();
    }
    public String getParameter(String key) {
        return parameters.get(key);
    }
}