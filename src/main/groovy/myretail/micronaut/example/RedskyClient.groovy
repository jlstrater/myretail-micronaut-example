package myretail.micronaut.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriTemplate
import io.reactivex.Flowable
import myretail.micronaut.example.model.RedskyProduct

import javax.inject.Singleton

@Singleton
class RedskyClient {

    private final RxHttpClient client
    private final String path

    RedskyClient(@Client(RedskyConfiguration.REDSKY_API_URL) RxHttpClient client) {
        this.client = client
        this.path = RedskyConfiguration.REDSKY_API_PATH
    }

    Flowable<RedskyProduct> fetchProduct(Integer id) {
        HttpRequest<?> request = HttpRequest.GET(constructUri(path, id))
        client.retrieve(request, RedskyProduct)
    }

    /*
     * This would normally be the micronaut expand method, but it doesn't seem to work with this combination of
     * UriTemplate and parameters
     */
    private static String constructUri(String path, Integer id) {
        UriTemplate.of(path + '/' + id + '?excludes=' + RedskyConfiguration.EXCLUDES)
    }

}
