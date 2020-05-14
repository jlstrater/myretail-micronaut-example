package myretail.micronaut.example.client

import io.micronaut.test.annotation.MicronautTest

import javax.inject.Inject
import javax.validation.ConstraintViolationException

import spock.lang.Specification

@MicronautTest
class RedskyClientSpec extends Specification {

    @Inject
    RedskyClient client

    @SuppressWarnings('LineLength')
    void "test uri construction"() {
        when:
        String uri = client.constructUri('api/v2', 12345)

        then:
        uri == 'api/v2/12345?excludes=taxonomy,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,available_to_promise_network,circle_offers'
    }

    void "test invalid input values"() {
        when:
        client.constructUri(null, null)

        then:
        ConstraintViolationException exception = thrown()
        exception.constraintViolations.size() == 2
        exception.message.contains('must not be null')
    }

}
