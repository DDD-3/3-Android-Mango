object ApplicationId {
    val id = "com.mango"
}

object Modules {
    val common = ":common"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0${versionCode}"
}

object Versions {
    const val kotlin = "1.3.61"
    const val gradle = "3.5.3"
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29
    const val appCompat = "1.0.2"
    const val coreKtx = "1.0.2"
    const val materialDesign = "1.1.0"
    const val constraintLayout = "1.1.3"
    const val retrofit = "2.6.0"
    const val retrofitGson = "2.6.0"
    const val gson = "2.8.5"
    const val okHttp = "3.12.1"
    const val dagger = "2.25.2"
    const val lifecycle = "2.1.0-alpha04"
    const val recyclerview = "1.0.0"
    const val glide = "4.9.0"
    const val ktx = "2.2.0-rc02"
    const val logger = "2.2.0"
}

object Libraries {
    // Dagger2
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    // RETROFIT
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ktxLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktx}"
    const val ktLifeCycler = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ktx}"
}

object AndroidLibraries {
    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
}

object UtilLibraries {
    const val logger = "com.orhanobut:logger:${Versions.logger}"


}