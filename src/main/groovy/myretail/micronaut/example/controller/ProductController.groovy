package myretail.micronaut.example.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import myretail.micronaut.example.model.RedskyProduct
import myretail.micronaut.example.service.ProductService

@Controller('/products')
class ProductController {

    protected final ProductService service

    ProductController(ProductService service) {
        this.service = service
    }

    @Get(uri= '/{id}', produces = MediaType.APPLICATION_JSON)
    Flowable<RedskyProduct> getProduct(Integer id) {
        service.getById(id)
    }

}
