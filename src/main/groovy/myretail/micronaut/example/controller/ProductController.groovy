package myretail.micronaut.example.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import myretail.micronaut.example.model.Product
import myretail.micronaut.example.service.ProductService

@Controller('/products')
class ProductController {

    protected final ProductService service

    ProductController(ProductService service) {
        this.service = service
    }

    @Get(uri = '/{id}', produces = MediaType.APPLICATION_JSON)
    Product getProduct(Integer id) {
        new Product(
                id: id,
                name: service.getNameById(id),
                currentPrice: service.getPricingById(id)
        )
    }

}
