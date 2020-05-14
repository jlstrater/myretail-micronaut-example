package myretail.micronaut.example.service

import io.reactivex.Flowable
import myretail.micronaut.example.model.RedskyProduct

import javax.inject.Singleton

@Singleton
interface ProductService {

    Flowable<RedskyProduct> getById(Integer id)

}
