package tests
import spock.lang.Unroll

    class CalculatorSpec extends BaseSpec {

        def setupSpec() {
            calc.open();
        }

        @Unroll
        def "Calculator test [#expression = #expected]"() {
            setup:
            calc.clear()

            expect:
            calc.calculate(expression) == expected

            where:
            expression            | expected
            "1+1"                 | "2"
            "-1-1"                | "-2"
            "0-1"                 | "-1"
            "1-0"                 | "1"
            "1/1"                 | "1"
            "1x1"                 | "1"
            "1.01+1.02"           | "2.03"
            "20000000000000002+3" | "20000000000000005"

        }
}
