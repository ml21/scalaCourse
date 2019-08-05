abstract class Base {
    def foo = 1
    def bar: Int
}

class Sub extends Base {
    override def foo = 10
    def bar = 20
}

val s = new Sub
s.foo
s.bar

