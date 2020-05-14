package myretail.micronaut.example.model.redsky

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Item {

    @JsonProperty('product_description')
    ProductDescription productDescription

}
