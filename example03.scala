object example03 {
	def apply() {
		val numbers = List(1, 2, 3, 4)
		// it will automatically delete duplicated entries, due to 
		// the fact it is set
		val sets = Set(1, 1, 2, 2, 3)

		// tuple are used for grouping together simple logical collections
		// of items without using a class
		val hostPort = ("localhost", 8080)
		// tuple don't have named accessors, they use 1-based position accessor
		// 1 based !!! 1 based !!!
		println(hostPort._1)
		println(hostPort._2)

		// tuple fit with pattern matching nicely [match ... case ... => ...]
		// tuple has some special way to make tuples of two values
		val twoTuple = 1 -> 2
		println(twoTuple)


		// Maps
		Map(1 -> 2)
		Map("foo" -> "bar")
		val map = Map(1 -> Map("foo" -> "bar"))
		// map with 1 -> 2 will automatically expands to (1, 2)

		// Option is a container which may or may not hold something.
		// basic interface for Option look like		
		// trait Option[T] {def isDefined: Boolean def get: T def getOrElse(t: T): T}
		// Option itself is generic and has two subclasses: Some[T] or None
		val mapNumbers = Map(1 -> "one", 2 -> "two")

		// Map.get use Option for it's return type. Option signifies to you
		// that the method might not be able to return what you're asking for
		// and that you should be prepared for that.
		println(mapNumbers.get(2))
		println(mapNumbers.get(3))

		// Combinator are so-called because they are meant to be combined
		// The output of one function is often suitable as the input for another
		// map: Evaluates a function over each element in the list
		// return a list with the same number of elements
		println(numbers.map((i: Int) => i * 2))

		// foreach: foreach is like map but returns nothing
		// foreach is intended for side-effects only
		println("foreach returns nothing: " + numbers.foreach((i: Int) => i * 2))

	}
}

// example03()
