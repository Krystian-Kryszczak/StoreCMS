package app.storecms.model.shopping.basis.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StockAvailability {
    final String central;
    final String local;
}