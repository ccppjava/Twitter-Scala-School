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
	}
}

example03()
