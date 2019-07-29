def thr: Int = {
  throw new Exception
}

def firstCbv(x: Int, y: Int) : Int = x
def firstCbn(x: Int, y: => Int) : Int = x

firstCbn(1, thr)

firstCbv(1, thr)
