// squared_numbers that removes all non-numbers from a polymorphic list 
// and returns the resulting list of squared numbers, e.g., 
// squared_numbers(1 :: "hello" :: 100 :: 3.14 :: ('a'::10::Nil) :: 'c' :: (5,7,'a') :: Nil) 
// should return List(1, 10000, 9.8596, List(100), (25,49)). 
// Note that it recursively applies to substructures.

//def squared_numbers(aList : List[Any]) : List[Any] = 	
// 


object Squared{
	def squared_numbers(list : List[Any]) : List[Any] = {
		var ret : List[Any] = List();
		for(X<-list){
			X match{
				case x : Int => ret = (x*x) :: ret;
				case x : Double => ret = (x*x) :: ret;
				case x : Char => ()
				case l : List[Any] => ret = squared_numbers(l) :: ret;
				case _ => ();
			}
		}
		ret.reverse;
	}
}

// intersect that given two generic lists, returns a new list that is the 
// intersection of the two lists (e.g., intersect(List(1,2,3,4,5), List(4,5,6,7,8)) 
// should return List(4,5)).

object Intersect{
	def intersect(list1 : List[Any], list2 : List[Any]) : List[Any] = {
		for (x <- list1; 
			y <- list2; 
			if x == y
			) yield x	
	}
}

// symmetric_difference that given two lists, returns a new list that is 
// the symmetric difference of the two lists. For example 
// symmetric_difference(List(1,2,3,4,5), List(4,5,6,7,8)) should 
// return List(1,2,3,6,7,8).

object Symmetric{
	def symmetric_difference(list1 : List[Any], list2 : List[Any]) : List[Any] = {
		var uno = for (x <- list1; 
			if !Intersect.intersect(list1, list2).contains(x)
			) yield x	
		var due = for (x <- list2; 
			if !Intersect.intersect(list1, list2).contains(x)
			) yield x	
		uno++due

	}
}
