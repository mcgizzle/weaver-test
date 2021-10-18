---
id: version-0.6.0-M1-installation
title: Installation
original_id: installation
---

Weaver-test is currently published for **Scala 2.12 and 2.13**

Weaver offers effect-type specific test frameworks. The Build setup depends on
the effect-type library you've elected to use (or test against).

Refer yourself to the library specific pages to get the specific configuration.

## SBT

Refer yourself to the [releases](https://github.com/disneystreaming/weaver-test/releases) page to know the latest released version, and add the following (or scoped equivalent) to your `build.sbt` file.

```scala
libraryDependencies += "com.disneystreaming" %% "weaver-cats" % "0.6.0-M1" % Test
testFrameworks += new TestFramework("weaver.framework.CatsEffect")
```

## Mill

```scala
import mill._, scalalib._

object foo extends ScalaModule {
  def scalaVersion = "2.13.1"

  object test extends Tests {
    def ivyDeps = Agg(
      ivy"com.disneystreaming::weaver-cats:0.6.0-M1",
      ivy"com.disneystreaming::weaver-scalacheck:0.6.0-M1"
    )
    def testFrameworks = Seq("weaver.framework.CatsEffect")
  }
}
```