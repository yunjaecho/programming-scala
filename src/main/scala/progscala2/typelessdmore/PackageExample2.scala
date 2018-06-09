package progscala2.typelessdmore

package com {
  package example {
    package pkg1 {
      class Class11 {
        def m = "m11"
      }
      class Class12 {
        def m = "m12"
      }
    }
    package pkg2 {
      class Class21 {
        def m = "m21"
        def makeClass11 = {
          new pkg1.Class11
        }
        def makeClass12 = {
          new pkg1.Class12
        }
      }
    }

    package pk3.pkag31.pkg311 {
      class Class31 {
        def m = "m31"
      }
    }
  }
}

object PackageExample2 extends App {

  import java.math.BigInteger.{
    ONE => _,
    TEN,
    ZERO => JAVAZERO
  }

  //println("ONE : " + ONE)
  println("TEN :" + TEN)
  println("ZERO: " + JAVAZERO)
}
