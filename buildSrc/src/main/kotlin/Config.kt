import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 21
    const val compileSdk = 29
    const val targetSdk = 28
    val javaVersion = JavaVersion.VERSION_1_8
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val baseUrlProd = "https://api.themoviedb.org/3/"
    const val baseUrlDev = "https://api.themoviedb.org/3/"

    const val movieDbBaseUrlProd = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTNkOTkzZTNmOGJhOGIzNDJmNTAyZjllZDY5ZTUzMiIsInN1YiI6IjVmMTQzMTViMWM2YWE3MDAzNTgxN2U2ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1R5tfdhb_LC_MqR1SrTDTtJKvWZsSQGC72WFlF4oiOU"
    const val movieDbBaseUrlDev = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYTNkOTkzZTNmOGJhOGIzNDJmNTAyZjllZDY5ZTUzMiIsInN1YiI6IjVmMTQzMTViMWM2YWE3MDAzNTgxN2U2ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.1R5tfdhb_LC_MqR1SrTDTtJKvWZsSQGC72WFlF4oiOU"

}
