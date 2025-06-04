package kr.lul.stringnotebook

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform