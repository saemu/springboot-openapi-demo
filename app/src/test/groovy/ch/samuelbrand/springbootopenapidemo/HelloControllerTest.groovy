package ch.samuelbrand.springbootopenapidemo

import ch.samuelbrand.model.Person
import org.springframework.http.HttpStatus
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class HelloControllerTest extends Specification {

    def "hello"() {
        when:
        final def controller = new HelloController()
        final def request = controller.hello()

        then:
        HttpStatus.OK == request.statusCode
        "Hello World" == request.body
    }

    def "helloName"() {
        given:
        final def controller = new HelloController()
        final def name = "Samuel"

        when:
        final def request = controller.helloName(name)

        then:
        HttpStatus.OK == request.statusCode
        "Hello Samuel" == request.body
    }

    def "helloPost"() {
        given:
        final def controller = new HelloController()
        final def person = Mock(Person)
        person.getFirstname() >> firstname
        person.getLastname() >> lastname
        person.getTitle() >> title

        when:
        final def request = controller.helloPost(person)

        then:
        HttpStatus.OK == request.statusCode
        final def expected = String.format("Hello %s %s %s", title, firstname, lastname)
        expected == request.body.getText()

        where:
        firstname | lastname | title
        "James"   | "Bond"   | "Mr."
        "Daisy"   | "Duck"   | "Mrs."
    }

    def "helloPost_null"() {
        given:
        final def controller = new HelloController()

        when:
        final def request = controller.helloPost(null)

        then:
        thrown(NullPointerException)
    }
}
