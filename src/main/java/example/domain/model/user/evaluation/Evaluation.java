package example.domain.model.user.evaluation;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Created by nishio on 2017/09/07.
 */
public class Evaluation {

    @DecimalMax(value = "5.0", message = "5.0以下で入力してください")
    @DecimalMin(value = "0.0", message = "0.0以上で入力してください")
    BigDecimal value = new BigDecimal("2.5");

    boolean validStep;
    @AssertTrue(message = "0.5刻みで入力してください")
    public boolean isValidStep() {
        BigDecimal test = value.remainder(new BigDecimal(0.5));
        return value.remainder(new BigDecimal(0.5)).equals(new BigDecimal(0.0));
    }

    @Override
    public String toString() {
        return value.toString();
    }


}
