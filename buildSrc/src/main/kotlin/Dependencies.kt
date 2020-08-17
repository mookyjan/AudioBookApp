object App{
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val buildToolVersion ="29.0.3"
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val GRADLE = "4.0.1"
    const val KOTLIN = "1.3.72"
    const val RETROFIT = "2.8.2"
    const val OK_HTTP = "4.7.2"
    const val TIMBER = "1.5.1"
    const val APP_COMPAT = "1.1.0"
    const val RECYCLER_VIEW = "1.1.0"
    const val SUPPORT ="1.0.0"
    const val COORDINATOR_LAYOUT = "1.1.0"
    const val DAGGER ="2.25.2"
    const val SHIMMER="0.1.0@aar"
    // 1.1.x version is required in order to support the dark theme functionality in
    // Android Q (adds Theme.MaterialComponents.DayNight)
    const val MATERIAL = "1.2.0-alpha05"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val CORE_KTX = "1.2.0"
    const val FRAGMENT_KTX = "1.2.4"
    const val LIFECYCLE = "1.1.1"
    const val LIFECYCLE_VIEW_MODEL_KTX = "2.2.0"
    const val COIL = "0.11.0"
    const val K_ANDROID = "0.8.7"
    const val LOTTIE = "3.4.0"
    const val RX_KOTLIN = "2.4.0"
    const val RX_ANDROID = "2.1.1"
    //    const val OKHTTP = "3.12.0"
    const val MOSHI = "1.9.0"
    const val MOSHI_LAZY_ADAPTER  = "2.2"
    const val  SDP = "1.0.6"
    const val NAVIGATION = "2.3.0"
    const val COROUTINES_ANDROID = "1.3.3"
    /* test */
    const val JUNIT = "4.12"
}

object Libs {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    // Required by Android dynamic feature modules and SafeArgs
    const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"
    const val MOSHI ="com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val MOSHI_ADAPTER= "com.serjltt.moshi:moshi-lazy-adapters:${Versions.MOSHI_LAZY_ADAPTER}"
    const val RX_ADAPTER ="com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT}"
    const val RX_KOTLIN = "io.reactivex.rxjava2:rxkotlin:${Versions.RX_KOTLIN}"
    const val RX_ANDROID=  "io.reactivex.rxjava2:rxandroid:${Versions.RX_ANDROID}"
    const val SDP ="com.intuit.sdp:sdp-android:${Versions.SDP}"
    // Retrofit will use okhttp 4 (it tas binary capability with okhttp 3)
    // See: https://square.github.io/okhttp/upgrading_to_okhttp_4/
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    const val TIMBER = "com.github.ajalt:timberkt:${Versions.TIMBER}"
    const val SUPPORT_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
    const val COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:${Versions.COORDINATOR_LAYOUT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val LIFECYCLE_EXTENSIONS = "android.arch.lifecycle:extensions:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VIEW_MODEL_KTX}"
    const val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val LIFECYCLE_EXT="androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_VIEW_MODEL_KTX}"
    const val ANDROIDX_LEGACY_SUPPORT="androidx.legacy:legacy-support-v4:${Versions.SUPPORT}"
    const val DAGGER_LIB =  "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_SUPPORT =   "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android-processor:${Versions.DAGGER}"
    const val SHIMMER_LIB =  "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
}

object TestLibs {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
}