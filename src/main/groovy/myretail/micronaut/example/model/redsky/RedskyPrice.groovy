package myretail.micronaut.example.model.redsky

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.micronaut.core.annotation.Introspected

@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
class RedskyPrice {

    OfferPrice offerPrice

}

