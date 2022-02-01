package com.example.dagger2practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import dagger.android.DaggerApplication
import dagger.android.DaggerApplication_MembersInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var burger: Burger

    @Inject
    lateinit var bun: WheatBun

    @Inject
    lateinit var patty: BeefPatty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* dagger 2를 사용하지 않는 기존 방법. 객체를 직접 가져오는 방법을 취한다. */
//        val bun: WheatBun = WheatBun()
//        val patty: BeefPatty = BeefPatty()
//
//        val burger = Burger(bun, patty)

        /* dagger 2를 사용하는 방법 (기본). */
        val component = DaggerBurgerComponent.builder().burgerModule(BurgerModule()).build()
        component.inject(this)

//        Log.d("burger", "burger bun: ${burger.bun.bun}, patty: ${burger.patty.patty}")
        val hello1 = findViewById<TextView>(R.id.hello1)
        val hello2 = findViewById<TextView>(R.id.hello2)
        val hello3 = findViewById<TextView>(R.id.hello3)

        hello1.text = "burger bun: ${burger.bun.bun}, patty: ${burger.patty.patty}"
        hello2.text = "bun: ${bun.bun}"
        hello3.text = "patty: ${patty.patty}"
    }
}