import org.junit.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class RotationSpec extends Specification {

    @Ignore
    @Unroll
    def "#n #array #expectedResult"(int n, int[] array, int[] expectedResult) {
        given:
        def rotation = new Rotation(n, array)
        when:
        def result = rotation.invoke()
        then:
        result == expectedResult
        where:
        n |  array    | expectedResult
        0 | [1, 2, 3] | [1, 2, 3]
        0 | [1, 2, 3] | [1, 2, 3]
        3 | [1, 2, 3] | [1, 2, 3]
    }

    @Unroll
    def "countNewPosition for #numberOfRotations and #arraySize and #index is #expectedResult"(int numberOfRotations, int arraySize, int index, int expectedResult) {
        given:
        Integer[] a = new Integer[arraySize]
        def rotation = new Rotation(numberOfRotations, a)
        when:
        def result = rotation.calculateIndexInRing(index)
        then:
        result == expectedResult
        where:
        numberOfRotations | arraySize | index  | expectedResult
        1                 | 3         | 0      | 1
        1                 | 3         | 1      | 2
        1                 | 3         | 2      | 0
        1                 | 3         | 2      | 0
        10                | 3         | 2      | 0
    }

    @Unroll
    def "convertFast #array after #numberOfRotations should be #expectedResult"(int numberOfRotations, Integer[] array, Integer[] expectedResult) {
        given:
        def rotation = new Rotation(numberOfRotations, array)
        when:
        def result = rotation.convertFast(numberOfRotations)
        then:
        result == expectedResult
        where:
        numberOfRotations | array       | expectedResult
        1                 | [1,2,3]     | [3,1,2]
        11                | [1,2,3,4,5] | [5,1,2,3,4]
    }
}
