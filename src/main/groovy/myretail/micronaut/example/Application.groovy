package myretail.micronaut.example

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
        info = @Info(
                title = 'Products API',
                version = '0.0',
                description = 'Aggregating production name and pricing information',
                license = @License(name = 'Apache 2.0', url = 'http://localhost:8080'),
                contact = @Contact(url = 'https://jennstrater.com', name = 'Jenn', email = 'jenn.strater@gmail.com')
        )
)
class Application {

    static void main(String[] args) {
        Micronaut.run(Application)
    }

}
