package myretail.micronaut.example.model

import com.fasterxml.jackson.annotation.JsonProperty

class Product {

    Integer id
    String name

    @JsonProperty('current_price')
    Price currentPrice

}
