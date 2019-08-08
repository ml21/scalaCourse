import week3._

trait Planar {
    def height: Int
    def width: Int
    def surface = height * width
}

def r1 = new Rational(1, 2)
def r2 = new Rational(1, 1)

r2 unary_-
r1 max r2
r1 max r2 unary_-
