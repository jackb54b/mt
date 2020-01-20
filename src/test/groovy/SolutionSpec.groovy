import kotlin.Pair
import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll


class SolutionSpec extends Specification {

    // @Ignore
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
        [1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0] | 1041
        [1, 1, 0, 0, 1, 0, 0] | 100
        [1,1,0,0,1] | 25
        [1,1,1] | 7
        [1,0,1] | 5
        [1,0]   | 2
        [1]     | 1
        [0]     | 0
    }

    @Unroll
    def "solution #number"(Pair expected, int number) {
        given:
        def solution = new Solution(number)
        when:
        def result = solution.solution()
        then:
        result == expected
        where:
        expected      | number
        [1,4]         | 214783644
        new Pair(0,6) | 1041
        [1,4]         | 100
        [1,4]         | 25
        [0,3]         | 9
        [0,0]         | 7
        [0,2]         | 5
        [0,0]         | 3
        [0,0]         | 2
        [0,0]         | 1
        [0,0]         | 0
    }
}