package com.camilogo1200.common.coroutines

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Retention(RUNTIME)
@Qualifier
annotation class DefaultDispatcher


@Retention(RUNTIME)
@Qualifier
annotation class IoDispatcher


@Retention(RUNTIME)
@Qualifier
annotation class MainDispatcher


@Retention(RUNTIME)
@Qualifier
annotation class MainImmediateDispatcher
