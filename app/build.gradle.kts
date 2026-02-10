plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt") // Necesario para Glide, Room y Hilt
    id("androidx.navigation.safeargs.kotlin")

    id("com.google.dagger.hilt.android") // Plugin de Hilt
    id("com.google.gms.google-services") // Plugin de Firebase
}

android {
    namespace = "com.example.canciones"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.canciones"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // Esto ayuda a que kapt funcione mejor con Hilt
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Navegación
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // GLIDE (Imágenes)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")


    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    val roomVersion = "2.6.1"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion") // Soporte para Corrutinas
    kapt("androidx.room:room-compiler:$roomVersion")

    // 3. FIREBASE (Login y Base de datos nube)
    // Importamos el BOM para que gestione las versiones automáticamente
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-auth-ktx") // Autenticación (Login)
    implementation("com.google.firebase:firebase-firestore-ktx") // Base de datos

    // 4. MVVM (ViewModel y LiveData)
    val lifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    // Fragment KTX (Para poder usar "by viewModels()")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}