import Versions.archCoreVersion
import Versions.coilVersion
import Versions.coroutineTestVersion
import Versions.hamcrestVersion
import Versions.paging_version
import Versions.preferencesKtxVersion
import Versions.roboElectricVersion
import Versions.roomVersion
import Versions.testCoreVersion

object Versions {
    const val coroutines = "1.3.9"
    const val kotlinVersion = "1.7.21"
    const val appcompat = "1.6.1"
    const val coreKtx = "1.7.0"
    const val material = "1.7.0"
    const val constraintLayout = "2.1.4"
    const val navigation = "2.3.5"
    const val retrofit = "2.9.0"
    const val httpInterceptor = "4.4.0"
    const val recyclerview = "1.1.0"
    const val lifecycle = "2.5.1"
    const val lifecycleExtension = "2.1.0"
    const val hilt = "2.44"
    const val hiltActivity = "1.2.0-beta01"
    const val junit = "4.13.2"
    const val junitExt = "1.1.4"
    const val espresso = "3.5.0"
    const val fragmentKtx = "1.5.5"
    const val testCoreVersion = "1.4.0"
    const val hamcrestVersion = "1.3"
    const val archCoreVersion = "2.1.0"
    const val roboElectricVersion = "4.3.1"
    const val coroutineTestVersion = "1.2.1"
    const val truthVersion = "1.0.1"
    const val mockitoVersion = "2.21.0"
    const val mockkVersion = "1.11.0"
    const val willowtreeappsVersion = "0.23"
    const val roomVersion = "2.4.0-alpha03"
    const val preferencesKtxVersion = "1.2.0"
    const val coilVersion = "2.4.0"
    const val paging_version = "3.0.0-alpha04"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"


    //navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.httpInterceptor}"

    //Recyclerview
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    //Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //Lifecycle
    const val lifecycleExtensionArch =
        "android.arch.lifecycle:extensions:${Versions.lifecycleExtension}"
    const val lifecycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtension}"
    const val lifecycleViewmodelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    //Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.hiltActivity}"

    //Fragment
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // Room
    const val roomKtx = "androidx.room:room-ktx:${roomVersion}"
    const val room = "androidx.room:room-runtime:${roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${roomVersion}"
    const val roomAnnotationProcessor = "androidx.room:room-compiler:${roomVersion}"

    //Shared preferences
    const val preferencesKtx = "androidx.preference:preference-ktx:${preferencesKtxVersion}"

    //coil
    const val coil = "io.coil-kt:coil:$coilVersion"

    //paging
    const val paging = "androidx.paging:paging-runtime:$paging_version"

    // TestImplementations
    const val testCore = "androidx.test:core:${testCoreVersion}"
    const val hamcrest = "org.hamcrest:hamcrest-all:${hamcrestVersion}"
    const val archCore = "androidx.arch.core:core-testing:${archCoreVersion}"
    const val roboElectric = "org.robolectric:robolectric:${roboElectricVersion}"
    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${coroutineTestVersion}"
    const val truth = "com.google.truth:truth:${Versions.truthVersion}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockitoVersion}"
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitExt = "androidx.test.ext:junit:${Versions.junitExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val willowtreeapps =
        "com.willowtreeapps.assertk:assertk:${Versions.willowtreeappsVersion}"
}
