package myretail.micronaut.example.model.redsky

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class ProductDescription {

    String title

}
