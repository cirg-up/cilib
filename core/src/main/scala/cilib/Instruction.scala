package cilib

import scalaz._

/**
  A Instruction is a type that models a single step in a CI Algorithm's operation.

  The general idea would be that you would compose different Instruction instances
  to produce the desired algorithmic behaviour.

  Even though this is an initial pass at modeling the compuation of CI algorithms
  this way, it does provide a recursive, list-like composition allowing a multitude
  of different usages (or it is hoped to be so).

  `Instruction` is nothing more than a data structure that hides the details of a
  monad transformer stack which represents the algoritm instruction.
  */
final class Instruction[A](val run: ReaderT[RVar, (Opt,Eval), A]) {

  def map[B](f: A => B): Instruction[B] =
    new Instruction(run map f)

  def flatMap[B](f: A => Instruction[B]): Instruction[B] =
    new Instruction(run flatMap (f(_).run))
}

object Instruction {
  import scalaz._

  def apply[A](s: Kleisli[RVar,(Opt,Eval),A]) =
    new Instruction(s)

  def point[A](a: A): Instruction[A] =
    new Instruction(Kleisli[RVar,(Opt,Eval),A]((e: (Opt,Eval)) => RVar.point(a)))

  def pointR[A](a: RVar[A]): Instruction[A] =
    new Instruction(Kleisli[RVar,(Opt,Eval),A]((e: (Opt,Eval)) => a))

  def liftK[A](a: Reader[Opt, A]): Instruction[A] =
    new Instruction(Kleisli[RVar,(Opt,Eval),A]((o: (Opt,Eval)) => RVar.point(a.run(o._1))))

  implicit val instructionMonad: Monad[Instruction] = new Monad[Instruction] {
    def point[A](a: => A) =
      Instruction.point(a)

    def bind[A, B](fa: Instruction[A])(f: A => Instruction[B]): Instruction[B] =
      fa flatMap f
  }
}
