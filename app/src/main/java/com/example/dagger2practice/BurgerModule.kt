package com.example.dagger2practice

import com.example.dagger2practice.WheatBun
import com.example.dagger2practice.BeefPatty
import com.example.dagger2practice.BurgerModule
import com.example.dagger2practice.MainActivity
import com.example.dagger2practice.Burger
import dagger.Module
import dagger.Provides

@Module
class BurgerModule {
    @Provides
    fun provideBurger(bun: WheatBun, patty: BeefPatty): Burger {
        return Burger(bun, patty)
    }

    @Provides
    fun provideBun(): WheatBun {
        return WheatBun()
    }

    @Provides
    fun providePatty(): BeefPatty {
        return BeefPatty()
    }
}