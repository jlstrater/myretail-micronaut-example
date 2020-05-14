package myretail.micronaut.example.service

import io.reactivex.Flowable
import myretail.micronaut.example.RedskyClient
import myretail.micronaut.example.model.RedskyProduct

import javax.inject.Inject

class ProductServiceImpl implements ProductService {

    @Inject
    final RedskyClient client

    ProductServiceImpl(RedskyClient client) {
        this.client = client
    }

    Flowable<RedskyProduct> getById(Integer id) {
        client.fetchProduct(id)
    }

}
