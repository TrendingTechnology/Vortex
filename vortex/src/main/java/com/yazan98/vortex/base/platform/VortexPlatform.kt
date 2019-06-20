package com.yazan98.vortex.base.platform

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/20/2019
 * Time : 3:55 PM
 */

object VortexPlatform {

    val DEPENDENCY_OBSERVABLE =
        findClassByClassName("io.reactivex.Observable")
    val DEPENDENCY_FLOWABLE =
        findClassByClassName("io.reactivex.Flowable")
    val DEPENDENCY_SINGLE = findClassByClassName("io.reactivex.Single")
    val DEPENDENCY_MAYBE = findClassByClassName("io.reactivex.Maybe")
    val DEPENDENCY_REPOSITORY =
        findClassByClassName("io.reactivex.disposables.CompositeDisposable")

    private fun findClassByClassName(className: String): Boolean {
        return try {
            Class.forName(className)
            true
        } catch (e: ClassNotFoundException) {
            false
        }
    }

}
