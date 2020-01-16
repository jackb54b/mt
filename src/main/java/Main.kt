class Person(var name: String? = null,
    var age: Int? = null,
    var add: Address? = null,
    var addresses: List<Address> = arrayListOf())

class Address(var street: String? = null)

fun person(block: Person.() -> Unit): Person = Person().apply(block)

fun Person.addresses(block: Address.() -> Unit ) {
    // var addresses: List<Address> = listOf()
    val  z = Address().apply(block)
    this.addresses += z

}

fun Person.add(block: Address.() -> Unit ): Address {
    this.add = Address().apply(block)
    return this.add!!
}


infix fun Int.PRINT(str: String) {
    repeat(this) {
        print(str + " ")
    }
}
