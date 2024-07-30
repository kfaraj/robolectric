import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  alias(libs.plugins.detekt)
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.robolectric.java.module)
  alias(libs.plugins.robolectric.spotless)
}

tasks.named<KotlinCompile>("compileKotlin").configure {
  compilerOptions.jvmTarget = JvmTarget.JVM_1_8
}

tasks.named<KotlinCompile>("compileTestKotlin").configure {
  compilerOptions.jvmTarget = JvmTarget.JVM_1_8
}

val axtCoreVersion: String by rootProject.extra

dependencies {
  api(project(":robolectric"))
  compileOnly(AndroidSdk.MAX_SDK.coordinates)
  implementation(libs.androidx.annotation)

  testCompileOnly(AndroidSdk.MAX_SDK.coordinates)
  testRuntimeOnly(AndroidSdk.MAX_SDK.coordinates)
  testImplementation(libs.kotlin.stdlib)
  testImplementation(libs.kotlinx.coroutines.android)
  testImplementation(libs.junit4)
  testImplementation(libs.truth)
  testImplementation("androidx.test:core:$axtCoreVersion@aar")
}