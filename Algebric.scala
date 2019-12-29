// Exercise 4: Playing around with Algebra.
// A monoid is an algebraic structure consisting of a set together with a 
// single associative binary operation and an identity element. E.g., the 
// set of booleans with the or operator is a monoid whose identity is false.

// A group is an algebraic structure consisting of a set together with an 
// operation that combines any two of its elements to form a third element. 
// To qualify as a group, the set and the operation must satisfy a few conditions 
// called group axioms, namely closure, associativity, identity and invertibility. 
// E.g., the set Z (the integers with sign) with the + operator is a group but 
// with the * is not since inverting the operation break the closure property.

// A ring is an algebraic structure consisting of a set together with two 
// binary operations (usually called addition and multiplication), where each 
// operation combines two elements to form a third element. 
// To qualify as a ring, the set together with its two operations must satisfy 
// certain conditions, namely, the set must be an abelian (i.e., commutative) 
// group under addition and a monoid under multiplication such that multiplication 
// distributes over addition.

// Write the Monoid, Group and Ring classess implementing the monoids, 
// groups and rings algebraic structures respectively. Each class must be 
// parametric on the algebraic sort, in the sense that the operations and the 
// sets are not a priori defined and they should implement operations to check 
// the properties characterizing the algebraic structure.

// Test your implementation with the following examples (S is the set, 
// add=additive operation, mul=multiplicative operation, i=identity):

// Monoids

// S = {True, False} add = or i = False
// S = Zn={0,1,...,n-1} add = + where a+b=(a+b)%n i = 0

//Groups

// S = {True, False}, add = or, i = False
// S = Z, add = +, i = 0
// S = Z4 = {0, 1, 2, 3}, add = * where a*b=(a*b)%4, i = 1
// S = {a}*, add: {a}*×{a}* --> {a}* where x1·x2 is x1 if #x1 > #x2, x2 otherwise, i = the empty string

// Rings

// S = {0} add = + where 0+0=0 mul = * where 0*0=0 i = 0
// S = Z add = + mul = * i = 0
// S = Z4 = {0,1,2,3} add = + where a+b=(a+b)%4 mul = * where a*b=(a*b)%4 i = 0
// Note property checks on infinite sets should be on a finite subset.

class Monoid[A](var S : List[A], add: (A,A) => A, identity: A) {
		
	def is_monoid = {
		var count = 0;
		var base = true;
		for (i <- S; j <- S) {
			 base = base && S.contains(add(i,j)) && (add(i,identity)==i)
		} 
		base
	}
	
}

// esempio:
// val booleans = new Monoid[Boolean](List(true,false), (x,y) => x || y, false)
// val zed = new Monoid[Int](List(0,1,2,3,4,5,6), (x,y) => (x + y)%7, 0)

class Group[A](var S : List[A], add: (A,A) => A, identity: A) {
		
	def is_group = {
		var base = true		
		for (i <- S; j <- S) {
			 base = base && S.contains(add(i,j)) && (add(i,identity)==i) && (add(i,j) == add(j,i))
		} 
		base
	}
	
}

class Ring[A](var S : List[A], add: (A,A) => A, mul: (A,A) =>A, identity: A) {
	
	
	def is_ring = {
		var base = true		
		for (i <- S; j <- S) {
			 base = base && S.contains(add(i,j)) && (add(i,identity)==i) && (add(i,j) == add(j,i))
		} 
		for (i <- S; j <-S; k <- S) {
			base = base && (mul(add(i,j), k) == add(mul(i,k),mul(j,k)))
		}
		base
	}
	
}

// val r1 = new Ring[Int](List(0,1,2,3), (x,y) => (x+y)%4, (x,y) =>(x*y)%4,0)
