// factors: int → int list that given a number calculates all its prime factors;

def factors(n: Int): Seq[Int] = {
	var lista = Range(1,n/2+1);
	lista.filter(n%_==0)			
}

def is_proper(n: Int) : Boolean = {
	n == factors(n).foldLeft(0)(_+_)
}
