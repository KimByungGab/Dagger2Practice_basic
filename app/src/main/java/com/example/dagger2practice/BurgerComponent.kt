package com.example.dagger2practice

import dagger.Component

@Component(modules = [BurgerModule::class])
interface BurgerComponent {
    fun inject(activity: MainActivity)
}