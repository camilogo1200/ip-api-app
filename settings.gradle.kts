pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
    }
}

rootProject.name = "IpInfo"
include(":app")
include(":common")
include(":ui:permissions")
include(":domain:ipmodels")
include(":data:repositories:local:database:room")
include(":data:repositories:local:database-api")
include(":data:repositories:remote")
include(":data:datasources")

include(":ui:demo")
include(":network")
include(":ui:dashboard")
include(":domain:usecases")
