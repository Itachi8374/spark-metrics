resolvers += "Maven2 repository" at "https://repo1.maven.org/maven2/"
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("com.github.sbt" % "sbt-pgp" % "2.2.1")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "3.10.0")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.1.5")
