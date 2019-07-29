package weaver.zio

import weaver.Log

import zio.UIO
import zio.Ref

import cats.data.Chain

class RefLog(ref: Ref[Chain[Log.Entry]]) extends Log[UIO] { self =>
  def log(l: => Log.Entry): zio.UIO[Unit] =
    ref.modify(current => ((), current.append(l)))

  trait lift extends LogModule {
    def log: Log[zio.UIO] = self
  }
}
