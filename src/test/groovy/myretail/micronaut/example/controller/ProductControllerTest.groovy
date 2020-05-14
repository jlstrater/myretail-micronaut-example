package myretail.micronaut.example.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import myretail.micronaut.example.model.Product
import myretail.micronaut.example.service.ProductService
import myretail.micronaut.example.service.ProductServiceImpl
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ProductControllerTest extends Specification {

    @Inject
    @Client('/products')
    RxHttpClient client

    @Inject
    ProductService productService

    void 'test getting a product by id'() {
        when:
        HttpRequest<Product> request = HttpRequest.GET('/1')
        String product = client.toBlocking().retrieve(request)

        then:
        product
        1 * productService.getById(1)
        0 * _
    }

    @SuppressWarnings('ConfusingMethodName')
    @MockBean(ProductServiceImpl)
    ProductService productService() {
        Mock(ProductService)
    }

}
