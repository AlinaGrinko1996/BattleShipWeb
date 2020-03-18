package ua.hrynko.geb

import geb.Page
import geb.spock.GebSpec

import org.springframework.boot.test.context.SpringBootTest

import ua.hrynko.AppConfiguration
import ua.hrynko.pages.GamePage

class IndexPage extends Page {
    static url = 'http://localhost:8080/'
    static at = { title.startsWith('Login') }
    static content = {
        email { $('#name1') }
        password { $('#name2') }
        submit { $("#login input[type=submit]") }
    }
}

@SpringBootTest(classes = AppConfiguration.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class LoginSpec extends GebSpec {
    def 'success login'() {
        setup:
        to LoginPage

        when:
        name1().value "aaa"
        name2().value "aaa"
        submit().click()

        then:
        at GamePage
    }
}
