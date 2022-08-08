package app.storecms.model.shopping.basis.payment;

import app.storecms.model.shopping.basis.product.ProductStack;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.data.annotation.Id;

import java.util.List;

@Value
@AllArgsConstructor
public class Payment {
    @Id
    String id;
    double bruttoPrice;
    @NonFinal
    boolean isPaid;
    private Payment(double bruttoPrice) {
        this.id = null;
        this.bruttoPrice = bruttoPrice;
        this.isPaid = false;
    }
    void setToHasBeenPaid() {
        isPaid = true;
        // TODO update in database
    }
    public static Payment create(List<ProductStack> productStackList) {
        return create(productStackList, List.of());
    }
    public static Payment create(List<ProductStack> productStackList, List<String> discountCodes) {
        double brutto = 0;
        // TODO
        return new Payment(brutto);
    }
}