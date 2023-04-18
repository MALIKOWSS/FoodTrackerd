plugins {
    Plugins.apply {
        id(application)
        kotlin(android)
        kotlin(kapt)
        id(hilt)
    }
    id("com.google.gms.google-services")
}

android {
    Config.apply {
        namespace = applicationId
        compileSdk = compileAndTargetSdk

        defaultConfig {
            applicationId = applicationId
            minSdk = Config.minSdk
            targetSdk = compileAndTargetSdk
            versionCode = Config.versionCode
            versionName = Config.versionName

            testInstrumentationRunner = Config.testInstrumentationRunner
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile(proguard), proguardRules)
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        kotlinOptions {
            jvmTarget = Config.jvmTarget
        }

        buildFeatures.viewBinding = true
    }
}

dependencies {
    implementation("com.google.firebase:firebase-firestore-ktx:24.1.1")
    Dependencies.UIComponents.apply {
        implementation(core)
        implementation(appCompat)
        implementation(material)
        implementation(constraint)
    }

    Dependencies.Hilt.apply {
        implementation(hilt)
        kapt(hiltCompiler)
    }

    Dependencies.Domain.apply {
        implementation(project(domain))
    }

    Dependencies.Data.apply {
        implementation(project(data))
    }

    Dependencies.Presentation.apply {
        implementation(project(presentation))
    }

    // data
    implementation(project(":data"))

    // domain
    implementation(project(":domain"))

    //presentation
    implementation(project(":presentation"))
}