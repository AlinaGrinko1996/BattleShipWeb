package ua.hrynko.pages

import com.formos.tapestry.testify.core.ForComponents
import com.formos.tapestry.testify.core.TapestryTester
import com.formos.tapestry.xpath.TapestryXPath

import org.apache.tapestry5.alerts.AlertManager
import org.apache.tapestry5.dom.Document
import spock.lang.Shared
import spock.lang.Specification

import ua.hrynko.services.QaModule

class NavigationSpec extends Specification {

    @Shared
    private TapestryTester tester

    def setupSpec() {
        tester = new TapestryTester("ua.hrynko", "app", "src/main/webapp", QaModule.class)
    }

    def "go to #pageName"() {
        when:
        Document document = tester.renderPage(pageName)
        String title = TapestryXPath.xpath("/html/head/title").selectSingleElement(document).getChildMarkup()

        then:
        title.startsWith(pageName)

        where:
        pageName << ["Index", "GamePage"]
    }
}
