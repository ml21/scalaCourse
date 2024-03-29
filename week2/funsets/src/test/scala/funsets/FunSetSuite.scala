package funsets

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  // test("string take") {
  //   val message = "hello, world"
  //   assert(message.take(5) == "hello")
  // }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
     assert(1 + 2 == 3)
   }


  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)

    val u123 = union(union(s1, s2), s3)
    val u234 = union(union(s2, s3), s4)

    val evens = union(s2, s4)
    val odds = union(s1, s3)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements of each set") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains only common elements") {
      new TestSets {
        val result = intersect(u123, u234)
        assert(contains(result, 2), "Intersect contains 2")
        assert(contains(result, 3), "Intersect contains 3")
        assert(!contains(result, 1), "Intersect does not contains 1")
        assert(!contains(result, 4), "Intersect does not contains 4")
      }
  }

  test("diff contains only differently elements") {
    new TestSets {
      val result = diff(u123, u234)
      assert(contains(result, 1), "Diff contains 1")
      assert(!contains(result, 4), "Diff does not contains 4")
      assert(!contains(result, 2), "Diff does not contains 2")
      assert(!contains(result, 3), "Diff does not contains 3")
    }
  }

  test("filter elements greater than 2") {
    new TestSets {
      val result = filter(u123, x => x < 3)
      assert(contains(result, 1), "Contains 1")
      assert(contains(result, 2), "Contains 2")
      assert(!contains(result, 3), "Contains 3")
    }
  }

  test("forall checks parity") {
    new TestSets {
      assert(forall(evens, x => x % 2 == 0) == true, "return true for even numbers")
      assert(forall(odds, x => x % 2 == 0) == false, "return false for odd numbers")
    }
  }

  test("exists checks parity") {
    new TestSets {
      assert(exists(u234, x => x % 2 ==0) == true, "returns true for even and odd numbers mix")
      assert(exists(odds, x => x % 2 ==0) == false, "returns false for only odd numbers")
    }
  }

  test("map converts odds into events") {
    new TestSets {
      val mapped = map(odds, x => x + 1)
      assert(forall(mapped, x => x % 2 == 0) == true, "returns true if odds successfully converted into evens")
    }
  }
}
