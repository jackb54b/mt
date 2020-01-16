import kotlin.math.pow

class Solution(val number:Int) {

    private var binary: List<Byte> = convert()

    fun solution(): Pair<Int, Int> {
        var start = -1
        var maxStart = 0
        var maxEnd = 0
        binary.forEachIndexed {
            index, element ->
            var prevIndex = index - 1
            if(element.toInt() == 1 && start == -1 ) {
                start = index
            }
            if(prevIndex>=0 && binary[prevIndex].toInt() == 1 && element.toInt() == 1) {
                start = index
            }
            if(prevIndex>=0 && binary[prevIndex].toInt() == 0 && element.toInt() == 1 && maxEnd - maxStart <= index - start) {
                maxStart = start
                maxEnd = index
                start = -1
            }
        }
        return Pair(maxStart, maxEnd)
    }

    //  [1, 1, 0, 0, 1, 0, 0] | 100
    fun convert(): List<Byte> {
        binary = emptyList()
        if(number == 0) {
            binary += 0
            return binary
        }

        var i:Int = 0
        var sum:Int = 0
        while (2.0f.pow(++i) <= number) {}
        i--
        binary += 1
        sum += 2.0f.pow(i).toInt()

        for(j in --i downTo 0) {
           if(sum + 2.0f.pow(j).toInt() <= number) {
               binary += 1
               sum += 2.0f.pow(i).toInt()
           } else {
               binary += 0
           }
        }
        return binary
    }

    fun binaryToIntValue(): Int {
        var sum = 0
        binary.asReversed().forEachIndexed() {
            index, bit -> sum += bit * 2f.pow(index).toInt()
        }
        return sum
    }
}
