# River-Core
Base Code To Build Android Applications With RxJava , Clean Architecture and VIPER Architecture
 
![appveyor](https://img.shields.io/appveyor/ci/Yazan98/River-Core.svg)
![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)
![Status](https://img.shields.io/badge/Project%20Status-Beta%20Version-yellow.svg)
![AndroidX](https://img.shields.io/badge/Android%20Status-AndroidX-green.svg)
![Version](https://img.shields.io/badge/Version-0.0.6-green.svg)


> Build Full Applications With One Library 

> Bintray Packages Status : https://bintray.com/yt98/River-Core

# Setup

Add Sonatype's snapshots repository:

```
 repositories {
    mavenCentral()
    maven {
      url 'https://oss.sonatype.org/content/repositories/snapshots/'
    }
  }
```

Build.gradle

```
    dependencies {
        implementation "com.yazan98.river.core:river-base-ktx:0.0.6"
        implementation "com.yazan98.river.core:river-android-ktx:0.0.6"
        implementation "com.yazan98.river.core:river-android-data-ktx:0.0.6"
        implementation "com.yazan98.river.core:river-android-extras-ktx:0.0.6"
    }
```

# Library Structure

Build Full Android Application With "River Core" Depends on

1. VIPER Architecture
2. RxJava 2
3. Clean Architecture

VIPER Architecture Components
1. V -> View
2. I -> Interactor
3. P -> Presenter
4. E -> Entity
5. R -> Router

# Library Components
1. Firebase Configuration
2. LeakCanary Configuration
3. Android Architecture Components
4. Utils
5. Network Calls With Retrofit and RxJava
6. Local Calls With Room 
7. UI Utils (Image Loaders / Utils)
8. Permissions
