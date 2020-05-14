package myretail.micronaut.example.service

import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands
import myretail.micronaut.example.client.RedskyClient
import myretail.micronaut.example.model.Price
import myretail.micronaut.example.model.redsky.RedskyProductList

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductServiceImpl implements ProductService {

    @Inject
    final StatefulRedisConnection redisConnection

    @Inject
    final RedskyClient apiClient

    ProductServiceImpl(RedskyClient apiClient, StatefulRedisConnection redisConnection) {
        this.apiClient = apiClient
        this.redisConnection = redisConnection
    }

    String getNameById(Integer id) {
        RedskyProductList list = apiClient.fetchProductName(id)
        BigDecimal price = list?.product?.price?.offerPrice?.price
        if (price) {
            savePrice(id, price)
        }

        list?.product?.item?.productDescription?.title
    }

    Price getPricingById(Integer id) {
        RedisCommands<String, String> commands = redisConnection.sync()

        Map<String, String> pricingInfo = commands.hgetall(id.toString())

        new Price(value: pricingInfo?.value?.toBigDecimal(), currencyCode: pricingInfo?.currencyCode)
    }

    /*
     * For data generation and demo purposes only
     */
    void savePrice(Integer id, BigDecimal price) {
        RedisCommands<String, String> commands = redisConnection.sync()
        commands.hset(id.toString(), 'value', price.toString())
        commands.hset(id.toString(), 'currencyCode', 'USD')
    }

}
