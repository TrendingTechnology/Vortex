package com.yazan98.vortex.base

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 2:49 PM
 */

object VortexConsts {

    const val EMPTY_REQUEST_REPO = "You Can't Clear Request Repository With Empty Set ... Add Requests Before Call This Method"
    const val EMPTY_VIEW = "Current View Not Attached ... Maybe You Forget To Call presenter.attachView(this)"
    const val OBSERVABLE_NOT_FOUND = "Maybe You Forgot To Implement RxJava 2 ... Observable Missing"
    const val FLOWABLE_NOT_FOUND = "Maybe You Forgot To Implement RxJava 2 ... Flowable Missing"
    const val MAYBE_NOT_FOUND = "Maybe You Forgot To Implement RxJava 2 ... Maybe Missing"
    const val SINGLE_NOT_FOUND = "Maybe You Forgot To Implement RxJava 2 ... Single Missing"
    const val REPOSITORY_NOT_FOUND = "Maybe You Forgot To Implement RxJava 2 ... CompositeDisposable Missing"
    const val EMPTY_VIEW_VM = "Current View Not Attached ... Maybe You Forget To Call viewModel.attachView(this)"

}
