lazy val scala212 = "2.12.15"
lazy val scala213 = "2.13.13"
lazy val supportedScalaVersions = List(scala212, scala213)
lazy val ioPrometheusVersion = "0.7.0"

lazy val root = (project in file("."))
  .settings(
    name := "spark-metrics",
    organization := "com.banzaicloud",
    organizationHomepage := Some(url("https://banzaicloud.com")),
    homepage := Some(url("https://github.com/banzaicloud/spark-metrics")),
    developers := List(
      Developer("stoader", "Sebastian Toader", "st0ad3r@gmail.com", url("https://github.com/stoader")),
      Developer("sancyx", "Sandor Magyari", "sancyx@gmail.com", url("https://github.com/sancyx")),
      Developer("baluchicken", "Balint Molnar", "balintmolnar91@gmail.com", url("https://github.com/baluchicken")),
      Developer("rayalex", "Aleksandar Dragojevic", "me@aleksandar.io", url("https://github.com/rayalex"))
    ),
    scmInfo := Some(ScmInfo(url("https://github.com/banzaicloud/spark-metrics"), "git@github.com:banzaicloud/spark-metrics.git")),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalaVersion := scala212,
    crossScalaVersions := supportedScalaVersions,
    libraryDependencies ++= Seq(
      "io.prometheus" % "simpleclient" % ioPrometheusVersion,
      "io.prometheus" % "simpleclient_dropwizard" % ioPrometheusVersion,
      "io.prometheus" % "simpleclient_common" % ioPrometheusVersion,
      "io.prometheus" % "simpleclient_pushgateway" % ioPrometheusVersion,
      "io.dropwizard.metrics" % "metrics-core" % "4.2.19" % Provided,
      "io.prometheus.jmx" % "collector" % "0.12.0",
      "org.apache.spark" %% "spark-core" % "3.5.0" % Provided,
      "com.github.sbt" % "junit-interface" % "0.13.3" % Test,
      // Spark shaded jetty is not resolved in scala 2.11
      // Described in https://issues.apache.org/jira/browse/SPARK-18162?focusedCommentId=15818123#comment-15818123
      // "org.eclipse.jetty" % "jetty-servlet"  % "9.4.18.v20190429" % Test
      ),
    Test/testOptions := Seq(Tests.Argument(TestFrameworks.JUnit, "-a"))
  )


publishMavenStyle := true

// Add sonatype repository settings
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

