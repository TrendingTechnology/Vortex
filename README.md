# River-Core
Architecture To Build Android Applications With RxJava , Clean Architecture and VIPER , MVVM Architecture
 
![appveyor](https://img.shields.io/appveyor/ci/Yazan98/River-Core.svg)
![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)
![Status](https://img.shields.io/badge/Project%20Status-Beta%20Version-yellow.svg)
![AndroidX](https://img.shields.io/badge/Android%20Status-AndroidX-green.svg)
![Version](https://img.shields.io/badge/Version-0.0.11-green.svg)


> Build Full Applications With One Library 

> Bintray Packages Status : https://bintray.com/yt98/River-Core


# Library Structure

![Untitled Diagram](https://user-images.githubusercontent.com/29167110/58758805-8b602c80-8529-11e9-9710-58b975eef96f.jpg)


# Setup

1. VIPER Architecture
2. MVVM Architecture

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
   
    // Setup River Core With Viper Architecture
    dependencies {
        def riverV = "0.0.11"
        implementation "com.yazan98.river.core:river-base-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-data-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-extras-ktx:${riverV}"
    }
    
    // Setup River Core With MVVM Architecture
    dependencies {
        def riverV = "0.0.11"
        implementation "com.yazan98.river.core:river-base-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-vm-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-data-ktx:${riverV}"
        implementation "com.yazan98.river.core:river-android-extras-ktx:${riverV}"
    }

```

# Library Structure

Build Full Android Application With "River Core" Depends on

1. VIPER Architecture
2. RxJava 2
3. Clean Architecture
4. MVVM Architecture

#### VIPER Architecture Components
1. V -> View
2. I -> Interactor
3. P -> Presenter
4. E -> Entity
5. R -> Router


#### MVVM Architecture Components
1. V -> View
2. I -> Interactor
3. VM -> ViewModel
4. E -> Entity

# Library Components
- Interactors -> (Observable - Single - Flowable - Maybe)
- Network With Retrofit and RxJava with Data Layer
- Local Storage Implementation with SharedPreferences and Room Database
- Firebase (Firestore - RealtimeDatabase - Messaging - Authentication)
- Permissions
- UI Utils
- UI Helpers -> (RecyclerView Decoration with Ready Adapter - ImageLoaders with Glide / Picasso / Fresco - ImagePicker)

# Usage

The Following Link have simple example about how to use library
(Written With Viper Architecture)
> https://github.com/Yazan98/River-Android-Sample
