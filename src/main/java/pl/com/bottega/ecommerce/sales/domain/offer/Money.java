package pl.com.bottega.ecommerce.sales.domain.offer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Money {

    String currency;

    BigDecimal amount;

    public Money subtract(Money value) {
        Money money = null;
        if(currency.equals(value.currency)) {
            money = new Money(currency, this.amount.subtract(value.getAmount()));
        }
        return money;
    }

    public void multiply(BigDecimal value) {
        this.amount = this.amount.multiply(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Money other = (Money) obj;
        if (currency == null) {
            if (other.currency != null) {
                return false;
            }
        } else if (!currency.equals(other.currency)) {
            return false;
        }
        if (amount == null) {
            if (other.amount != null) {
                return false;
            }
        } else if (!amount.equals(other.amount)) {
            return false;
        }
        return true;
    }

}
