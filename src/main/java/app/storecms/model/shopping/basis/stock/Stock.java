package app.storecms.model.shopping.basis.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Stock {
    final int qty;
    final String unit;
    final StockAvailability availability;
}