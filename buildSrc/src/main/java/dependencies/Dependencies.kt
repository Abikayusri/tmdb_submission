package dependencies


/**
 * @author by Abika Chairul Yusri on 9/14/2022
 */
object Dependencies {

    object AndroidX {
        private const val coreKtxVersion = "1.7.0"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

        private const val appCompatVersion = "1.4.0"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
    }

    object Build {
        private const val androidBuildToolsVersion = "7.0.4"
        const val androidBuildTools = "com.android.tools.build:gradle:$androidBuildToolsVersion"

        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"

        private const val hiltAndroidGradlePluginVersion = "2.38.1"
        const val hiltAndroidGradlePlugin =
            "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.0-alpha03"
        const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0-rc01"
        const val swipe = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0-rc01"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val fragment = "androidx.fragment:fragment-ktx:1.5.2"
        const val activity = "androidx.activity:activity-ktx:1.5.1"

        private const val lifecycleVersion = "2.5.1"
        private const val lifecycleExtensionVersion = "2.2.0"
        const val lifecycleViewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionVersion"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:$lifecycleVersion"
        const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
        const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"

        private const val stdblibVersion = "1.6.21"
        const val stdlibCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:$stdblibVersion"
        const val stdlibJvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$stdblibVersion"
        const val stdlibJs = "org.jetbrains.kotlin:kotlin-stdlib-js:$stdblibVersion"
    }

    object Coroutines {
        private const val coroutinesVersion = "1.6.4"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
        const val coroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
        const val coroutinesReactive =
            "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$coroutinesVersion"
        const val coroutinesPlayServices =
            "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
        const val coroutinesDebug =
            "org.jetbrains.kotlinx:kotlinx-coroutines-debug:$coroutinesVersion"
    }

    object DaggerHilt {
        const val version = "2.43.2"
        const val hiltAndroid = "com.google.dagger:hilt-android:$version"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$version"
    }

    object Google {
        private const val materialVersion = "1.4.0"
        const val material = "com.google.android.material:material:$materialVersion"
    }

    object Glide {
        const val version = "4.12.0"
        const val core = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object Kotlin {
        const val version = "1.6.10"
    }

    object Okhttp {
        private const val okhttpVersion = "4.9.3"
        const val client = "com.squareup.okhttp3:okhttp:$okhttpVersion"
        const val log = "com.squareup.okhttp3:logging-interceptor:$okhttpVersion"
        const val ktor = "io.ktor:ktor-client-okhttp:1.3.1"
    }

    object Paging {
        private const val pagingVersion = "3.1.0"
        const val core = "androidx.paging:paging-runtime-ktx:$pagingVersion"
    }

    object Retrofit {
        private const val retrofitVersion = "2.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    }

    object Room {
        private const val roomVersion = "2.4.0"
        const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
        const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    }

    object RxPrefs {
        private const val rxVersion = "2.0.3"
        const val core = "com.afollestad.rxkprefs:core:$rxVersion"
        const val coroutine = "com.afollestad.rxkprefs:coroutines:$rxVersion"
    }

    object SharedPrefs {
        private const val sharedPrefVersion = "1.2.0"
        const val sharedPref = "androidx.preference:preference:$sharedPrefVersion"
        const val sharedPrefKtx = "androidx.preference:preference-ktx:$sharedPrefVersion"
    }

    object Testing {
        private const val junitVersion = "4.13.2"
        const val junit4 = "junit:junit:$junitVersion"

        private const val junitAndroidExtVersion = "1.1.3"
        const val junitAndroidExt = "androidx.test.ext:junit:$junitAndroidExtVersion"

        private const val coroutinesTestVersion = "1.5.1"
        const val coroutines =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutinesTestVersion"

        private const val truthVersion = "1.1.3"
        const val truth = "com.google.truth:truth:$truthVersion"

        private const val mockkVersion = "1.10.0"
        const val mockk = "io.mockk:mockk:$mockkVersion"
        const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

        private const val turbineVersion = "0.7.0"
        const val turbine = "app.cash.turbine:turbine:$turbineVersion"

        private const val mockWebServerVersion = "4.9.3"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"


        const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.version}"

        private const val testRunnerVersion = "1.4.0"
        const val testRunner = "androidx.test:runner:$testRunnerVersion"

        private const val espressoVersion = "3.4.0"
        const val testEspressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"

        private const val multidexVersion = "2.0.1"
        const val multidex = "androidx.multidex:multidex:$multidexVersion"
        const val multidexInstrument = "androidx.multidex:multidex-instrumentation:$multidexVersion"
        
        private const val gsonVersion = "2.9.0"
        const val gson = "com.google.code.gson:gson:$gsonVersion"

        private const val roomVersion = "2.4.3"
        const val roomTesting = "androidx.room:room-testing:$roomVersion"
    }

    object Chucker {
        private const val chuckerVersion = "3.5.2"
        const val core = "com.github.chuckerteam.chucker:library:$chuckerVersion"
    }
}