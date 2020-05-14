package myretail.micronaut.example.client

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriTemplate

import io.reactivex.Flowable

import javax.inject.Singleton
import javax.validation.constraints.NotNull

import myretail.micronaut.example.model.redsky.RedskyProductList

@Singleton
class RedskyClient {

    private final RxHttpClient client
    private final String path

    RedskyClient(@Client(RedskyConfiguration.REDSKY_API_URL) RxHttpClient client) {
        this.client = client
        this.path = RedskyConfiguration.REDSKY_API_PATH
    }

    /*
     * This needs an error handler for 404s.
     */
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
    String constructUri(@NotNull String path, @NotNull Integer id) {
        UriTemplate.of(path + '/' + id + '?excludes=' + RedskyConfiguration.EXCLUDES)
    }

}
