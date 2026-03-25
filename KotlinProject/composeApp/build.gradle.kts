import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.koin) // Complemento del compilador Koin
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }


    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }


    jvm()

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        //.\gradlew :composeApp:wasmJsBrowserDevelopmentRun
        /* Lo que ocurre por debajo cuando ejecutas wasmJsBrowserDevelopmentRun:
         Gradle descarga Node.js automáticamente (lo gestiona el plugin de Kotlin/JS, no tienes que instalarlo tú).
         Node ejecuta Webpack Dev Server.
         Webpack Dev Server sirve tu app en http://localhost:8080 (o similar) y abre el navegador.
         Puedes ver dónde lo descarga Gradle en:
         C:\Users\usuario\.gradle\nodejs\
         */
        browser ()
        binaries.executable()
    }

    sourceSets {

        androidMain.dependencies {
            //    implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.activity.compose)
            //   implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)


            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.compose.material.icons.extended)


            implementation(libs.androidx.navigation3.ui)

            implementation(libs.androidx.material3.navigation3)
            implementation(libs.androidx.lifecycle.viewmodel.navigation3)

            implementation(libs.koin.core)

            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.annotations)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
    }
}

android {
    namespace = "com.pmdm.ejemplokmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.pmdm.ejemplokmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.uiTooling)

}

compose.desktop {
    application {
        mainClass = "com.pmdm.ejemplokmp.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.pmdm.ejemplokmp"
            packageVersion = "1.0.0"
        }
    }
}

//Tarea para compilar en XCode en este caso no sirve porque se hace en GitHub Action
/*tasks.register("assembleDebugAppleFrameworkForXcode") {
    group = "build"
    description = "Ensambla el framework de Debug para Xcode (compatibilidad)."
    // Dependencia directa al task generado por KMP para el framework debug del simulador ARM64.
    dependsOn(tasks.named("linkDebugFrameworkIosSimulatorArm64"))
}*/