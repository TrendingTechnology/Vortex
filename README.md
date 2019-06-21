# Vortex
    Project Starter To Build Android Applications With RxJava
    
    Vortex Have Two Ways To Use (Mvvm Or Viper) architecture both of them powered by RxJava 2 ... at this library you have full common configuration to build any android application 
    
![Build Status](https://img.shields.io/appveyor/ci/Yazan98/Vortex.svg)
![Status](https://img.shields.io/badge/Project%20Status-Beta%20Version-brightgreen.svg)
![Version](https://img.shields.io/badge/Version-0.0.1-orange.svg)
![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)
![Android](https://img.shields.io/badge/Android%20Status-AndroidX-green.svg)
[![forthebadge](https://forthebadge.com/images/badges/built-for-android.svg)](https://forthebadge.com)

# Application Basic Flow

![](https://raw.githubusercontent.com/Yazan98/Vortex/master/images/Viper%20Archi.jpg)

> Bintray Package Status : https://bintray.com/yt98/Vortex

# Dependency

1. Viper Architecture
2. ViewModel Architecture

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
   
    // Setup Vortex With Viper Architecture
    dependencies {
        implementation "io.reactivex.rxjava2:rxjava:2.2.10"
        implementation "com.yazan98.vortex:vortex-core-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-data-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-extras-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-viper-ktx:{final-version}"
    }
    
    // Setup Vortex With MVVM Architecture
    dependencies {
        implementation "io.reactivex.rxjava2:rxjava:2.2.10"
        implementation "com.yazan98.vortex:vortex-core-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-data-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-extras-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-viewmodel-core-ktx:{final-version}"
        implementation "com.yazan98.vortex:vortex-viewmodel-ktx:{final-version}"
    }
```

 # Sample usage
![](https://img.shields.io/badge/Project%20Status-In%20Progress-yellow.svg)

## License

```
     Copyright (C) 2019 Yazan Tarifi
     Licensed under the Apache License, Version 2.0
```
