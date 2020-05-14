package myretail.micronaut.example.model

import com.fasterxml.jackson.annotation.JsonProperty

class Price {

    BigDecimal value

    @JsonProperty('currency_code')
    String currencyCode

}
