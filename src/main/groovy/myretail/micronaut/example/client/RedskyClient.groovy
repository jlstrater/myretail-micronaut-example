package myretail.micronaut.example.client

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriTemplate
import io.reactivex.Flowable
import myretail.micronaut.example.model.redsky.RedskyProductList

import javax.inject.Singleton

@Singleton
class RedskyClient {

    private final RxHttpClient client
    private final String path

    RedskyClient(@Client(RedskyConfiguration.REDSKY_API_URL) RxHttpClient client) {
        this.client = client
        this.path = RedskyConfiguration.REDSKY_API_PATH
    }

    @SuppressWarnings('UnnecessaryReturnKeyword')
    RedskyProductList fetchProductName(Integer id) {
        HttpRequest<?> request = HttpRequest.GET(constructUri(path, id))
        Flowable flowable = client.retrieve(request, RedskyProductList)

        return flowable.firstElement().blockingGet()
    }

    /*
     * This would normally be the micronaut expand method, but it doesn't seem to work with this combination of
     * UriTemplate and parameters
     */
    private static String constructUri(String path, Integer id) {
        UriTemplate.of(path + '/' + id + '?excludes=' + RedskyConfiguration.EXCLUDES)
    }

}
