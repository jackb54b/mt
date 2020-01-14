import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll


class SolutionSpec extends Specification {

    @Ignore
    @Unroll
    def " #binary is #expectedResult"(List<Byte> binary, int expectedResult) {
        given:
            def solution = new Solution(5)
            solution.binary = binary
        when:
            def result = solution.binaryToIntValue()
        then:
            result == expectedResult
        where:
            binary  | expectedResult
            [1,0,1] | 5
            [0,0,1] | 1
            [0,0,0] | 0
    }

    @Unroll
    def "convert #number"(List<Byte> binary, int number) {
        given:
        def solution = new Solution(number)
        when:
        def result = solution.convert()
        then:
        result == binary
        where:
        binary  | number
        [1,1,1] | 7
        [1,0,1] | 5
        [1,0]   | 2
        [1]     | 1
        [0]     | 0
    }
}