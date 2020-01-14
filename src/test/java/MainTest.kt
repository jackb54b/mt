import org.junit.Ignore
import org.junit.Test

class MainTest {
    @Test
    fun whenInvokeMain1() {

        10 PRINT "x"
    }


    @Ignore
    @Test
    fun whenInvokeMain() {
        val person: Person = person {
            name ="PAv"
            age = 3
            add {
                street = "oldone"
            }
            addresses {
                street = "Komp"
            }
            addresses {
                street = "OBron"
            }
        }
        println ("person: ${person.name}; ${person.age}; ${person.add!!.street}")
        println ("person: ${person.name}; ${person.age}; ${person.addresses!!.first().street}")
        println ("person: ${person.name}; ${person.age}; ${person.addresses!![1].street}")
    }
}
