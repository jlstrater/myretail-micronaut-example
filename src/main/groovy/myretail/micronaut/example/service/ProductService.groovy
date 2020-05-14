package myretail.micronaut.example.service

import myretail.micronaut.example.model.Price

import javax.inject.Singleton

@Singleton
interface ProductService {

    String getNameById(Integer id)

    Price getPricingById(Integer id)

}
