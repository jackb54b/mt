open class T
internal class X : T()

class Rotation<X : Any>(val numberOfRotations:Int = 1, val array: Array<Any>) {

    fun invoke(): Array<Any> {
        var result: Array<Any> = arrayOf<Any>()
        var tmpArray: Array<Any> = arrayOf<Any>()
        var tmp: Any
        for (i in 1..calculateIndexInRing(numberOfRotations)) {
            tmp = array[i]
            if (i+1 < array.size) {
                array[i+1] = array[i]
            } else{
                array[0] = array[i]
            }
        }
        return result
    }

    fun calculateIndexInRing(index: Int = 0):Int {
        var result = index + numberOfRotations
        if (result >= array.size ) {
            result %= array.size
        }
        return result
    }

    fun convertFast(index:Int): Array<Any> {
        var result: Array<Any?> = arrayOfNulls(array.size)
        array.forEachIndexed {
            index, it -> result[calculateIndexInRing(index)] = it
        }
        return result.filterNotNull().toTypedArray()
    }
}

fun main() {
    var r = Rotation<Int>(2, arrayOf(1,4))
    r.invoke()
    print("a")
}
