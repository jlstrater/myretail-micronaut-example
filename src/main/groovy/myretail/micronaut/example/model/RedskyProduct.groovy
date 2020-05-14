package myretail.micronaut.example.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.micronaut.core.annotation.Introspected

@Introspected
@JsonIgnoreProperties(ignoreUnknown = true)
class RedskyProduct {

    Map product

}
