package com.yazan98.vortex.base.error

/**
 * Copyright (C) 2019 Yazan Tarifi
 * Licensed under the Apache License, Version 2.0
 *
 * Created By : Yazan Tarifi
 * Date : 6/19/2019
 * Time : 3:01 PM
 */
class VortexInvalidException(override var message: String) : VortexException(message)