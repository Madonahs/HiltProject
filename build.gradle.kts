// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories{
        mavenLocal()
        google()
        jcenter()
    }
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.1.2")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.30.1-alpha")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        jcenter()
    }
}

tasks{
    val clean by registering(Delete::class){
        delete(rootProject.buildDir)
    }
}