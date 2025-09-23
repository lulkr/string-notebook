package kr.lul.stringnotebook.navigation.navigator

abstract class AbstractNavigator(
    val base: BaseNavigator
) : Navigator by base