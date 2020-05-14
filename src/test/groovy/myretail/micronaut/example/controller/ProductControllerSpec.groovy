package myretail.micronaut.example.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import myretail.micronaut.example.model.Price
import myretail.micronaut.example.model.Product
import myretail.micronaut.example.service.ProductService
import myretail.micronaut.example.service.ProductServiceImpl
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ProductControllerSpec extends Specification {

    @Inject
    @Client('/products')
    RxHttpClient client

    @Inject
    ProductService productService

    void 'test getting a product by id'() {
        when:
        HttpRequest<Product> request = HttpRequest.GET('/1')
        Product product = client.toBlocking().retrieve(request, Product)

        then:
        product
        product.id == 1
        product.name == 'foo'
        product.currentPrice

        1 * productService.getNameById(1) >> {  'foo' }
        1 * productService.getPricingById(1) >> {  new Price(currencyCode: 'USD', value: 1.99) }
        0 * _
    }

    @SuppressWarnings('ConfusingMethodName')
    @MockBean(ProductServiceImpl)
    ProductService productService() {
        Mock(ProductService)
    }

}
