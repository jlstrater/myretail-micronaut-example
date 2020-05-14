package myretail.micronaut.example.model

import com.fasterxml.jackson.annotation.JsonProperty

import javax.validation.constraints.DecimalMin

class Price {

    @DecimalMin(value = '0.0', inclusive=false)
    BigDecimal value

    @JsonProperty('currency_code')
    String currencyCode

}
