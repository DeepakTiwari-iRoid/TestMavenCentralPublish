import com.android.manifmerger.ManifestSystemProperty

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.vanniktech.publish)
}

android {
    namespace = "com.test.testlib"
    compileSdk = 36
    group = "io.github.deepaktiwari-iroid"
    version = "1.0.0"


    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    mavenPublishing {
        coordinates(group.toString(), project.name, version.toString())

        pom {
            name.set("Test Lib SDK")
            description.set("Android Lib for Testing and Learning Purpose")
            inceptionYear.set("2025")
            url.set("https://github.com/DeepakTiwari-iRoid/TestMavenCentralPublish.git")
            licenses {
                license {
                    name.set("The Apache Software License, Version 2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    distribution.set("repo")
                }
            }
            developers {
                developer {
                    id.set("DeepakTiwari-iRoid")
                    name.set("Deepak Tiwari")
                    url.set("https://github.com/DeepakTiwari-iRoid")
                    email.set("deepak.iroidsolutions@gmail.com")
                }
            }
            scm {
                url.set("https://github.com/DeepakTiwari-iRoid/TestMavenCentralPublish.git")
                connection.set("scm:git:git://github.com/DeepakTiwari-iRoid/TestMavenCentralPublish.git")
                developerConnection.set("scm:git:ssh://git@github.com/DeepakTiwari-iRoid/TestMavenCentralPublish.git")
            }
        }
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}