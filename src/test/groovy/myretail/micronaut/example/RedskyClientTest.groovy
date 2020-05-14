package myretail.micronaut.example

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class RedskyClientTest extends Specification {

    @Inject
    RedskyClient client

    @SuppressWarnings('LineLength')
    void "test uri construction"() {
        when:
        String uri = client.constructUri('api/v2', 12345)

        then:
        uri == 'api/v2/12345?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,available_to_promise_network,circle_offers'
    }

}
