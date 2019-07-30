// https://www.coursera.org/learn/progfun1/lecture/f6IQm/lecture-1-4-conditionals-and-value-definitions

def loop: Boolean = loop

// and implementation without &&
//def and(x: Boolean, y: Boolean): Boolean = {
//  if(!x) false
//  else if(!y) false
//  else true
//}
def and(x: Boolean, y: => Boolean): Boolean = if(x) y else false

val expectedTrue = and(true, true)
val expectedFalse1 = and(false, false)
val expectedFalse2 = and(true, false)
val expectedFalse3 = and(false, true)
val expectedFalse4 = and(false, loop) // y will not calculus because of call-by-name (=> in function declaration)

// or implementation without ||
//def or(x: Boolean, y: Boolean): Boolean = {
//  if(x) true
//  else if(y) true
//  else false
//}
def or(x: Boolean, y: => Boolean): Boolean = if(x) true else y

val expectedFalse = or(false, false)
val expectedTrue1 = or(true, true)
val expectedTrue2 = or(true, false)
val expectedTrue3 = or(false, true)
val expectedTrue4 = or(true, loop)

//Write a function and such that for all argument expressions x and y:
//
//  and(x,y) == x && y
//Please give your answer on one single line.
//
//(do not use && or || in your implementation)

