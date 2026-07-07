import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    androidLibrary {
        namespace = "io.github.semenciuccosmin.lexiscore.shared"
        compileSdk = libs.versions.compileSdk.get().toInt()
        minSdk = libs.versions.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    room {
        schemaDirectory("$projectDir/schemas")
    }

    sourceSets {
        androidMain.dependencies {
            // ANDROIDX
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            // COMPOSE
            implementation(libs.compose.uiToolingPreview)

            // ROOM
            implementation(libs.room.runtime)
            implementation(libs.room.ktx)
        }
        commonMain.dependencies {
            // COMPOSE
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)

            // KOIN
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // KOTLINX
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.immutableCollections)

            // OKIO
            implementation(libs.okio)

            // NAVIGATION
            implementation(libs.navigation.compose)
        }
        commonTest.dependencies {
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
    kspAndroid(libs.room.compiler)
}
