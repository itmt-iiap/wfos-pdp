
lazy val aggregatedProjects: Seq[ProjectReference] = Seq(
  `wfos-bgrxassembly`,
  `wfos-bgrx-lgripHcd`,
  `wfos-bgrx-rgripHcd`,
  `wfos-bgrx-lgmhcd`,
  `wfos-wfos-icsdeploy`
)

lazy val `wfos-ics-root` = project
  .in(file("."))
  .aggregate(aggregatedProjects: _*)

// assembly module
lazy val `wfos-bgrxassembly` = project
  .dependsOn(
    `wfos-bgrx-lgripHcd`,
    `wfos-bgrx-rgripHcd`,
    `wfos-bgrx-lgmhcd`,
    
  )
  .settings(
    libraryDependencies ++= Dependencies.bgrxassembly
  )

// hcd module
lazy val `wfos-bgrx-lgripHcd` = project
  .settings(
    libraryDependencies ++= Dependencies.lgripHcd
  )

  // hcd module
lazy val `wfos-bgrx-rgripHcd` = project
  .settings(
    libraryDependencies ++= Dependencies.rgripHcd
  )

  // hcd module
lazy val `wfos-bgrx-lgmhcd` = project
  .settings(
    libraryDependencies ++= Dependencies.lgmhcd
  )

// deploy module
lazy val `wfos-wfos-icsdeploy` = project
  .dependsOn(
    `wfos-bgrxassembly`,
    `wfos-bgrx-lgripHcd`,
    `wfos-bgrx-rgripHcd`,
    `wfos-bgrx-lgmhcd`

  )
  .settings(
    libraryDependencies ++= Dependencies.WfosIcsDeploy
  )
