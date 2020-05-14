package myretail.micronaut.example.client

import javax.inject.Singleton

@Singleton
class RedskyConfiguration {

    static final String REDSKY_API_URL = 'https://redsky.target.com'
    static final String REDSKY_API_PATH = '/v2/pdp/tcin'

    @SuppressWarnings('LineLength')
    static final String EXCLUDES = 'taxonomy,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics,available_to_promise_network,circle_offers'

}
