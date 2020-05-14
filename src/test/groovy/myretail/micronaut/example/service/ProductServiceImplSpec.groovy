package myretail.micronaut.example.service

import io.micronaut.core.io.socket.SocketUtils
import io.micronaut.test.annotation.MicronautTest
import myretail.micronaut.example.model.Price
import redis.embedded.RedisServer
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class ProductServiceImplSpec extends Specification {

    @Inject
    ProductServiceImpl productService

    void "save price and then get the result"() {
        given:
        RedisServer redisServer = new RedisServer(SocketUtils.findAvailableTcpPort())
        redisServer.start()
        Integer id = 12345
        BigDecimal value = 1.00

        when:
        productService.savePrice(id, value)

        then:
        Price price = productService.getPricingById(id)
        price
        price.value == value
        price.currencyCode == 'USD'
        0 * _

        cleanup:
        redisServer.stop()
    }

}
