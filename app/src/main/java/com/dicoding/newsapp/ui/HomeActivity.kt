package com.dicoding.newsapp.ui

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.newsapp.R
import com.dicoding.newsapp.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewPager.adapter = sectionsPagerAdapter
        TabLayoutMediator(
            binding.tabs, binding.viewPager
        ) { tab: TabLayout.Tab, position: Int ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }
}

/* REPOSITORY THEORY */
// 'Repository' is a class to 'gather' all 'data-related process'.
// 'Repository' overrides DAO to gather data as DDD (Domain Driver Design) is getting popular
// 'Repository' often handle data from API, DB, & Cache

// S in SOLID Principles: Singe Responsibility
// - 1 class can only do 1 task

// benefit in using 'Repository' pattern:
// - Separate app from data source
// - Provides data from various resources (API, database, cache)
// - Isolate data layer
// - 1 control, centralized, consistent access towards data
// - Easy to test towards business logic in Unit Test
// - Easy to add new data source

// Repository Component:
// - Local database (ROOM, SQLite, Realm, GreenDao, etc)
// - Remote Database (Cloud via API (MySql, Firebase, etc))
// - Cache (save specific data types)
// - Preferences (simple key-value data storage)

// Best practice on Repository:
// - Naming using "Data type + Repository" (NoteRepository, MovieRepository, etc)
// - Separate Repository for each different data (WeatherRepository vs PaymentRepository, etc)
// - Create Multilevel Repository for big repository (Repo inside Repo) (LoginRepository & RegisRepository inside UserRepository)
// - If there is more than 1 datasource, make sure of SSoT (Single Source of Truth) (consistency of data source)

// Repository case study: https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/academy/dos:ffda0676173f26ea8c1abfa8345371ad20220110174445.jpeg

// Composition vs Inheritance:
// - Composition / Aggregation is a new class that is arranged by existing class from another class
// - Inheritance is inheriting new class by modifying existing class

// Attention on making Composite Pattern:
// - only apply on object that has the same behavior
// - it is used to create a tree structure using class that represents part-whole structure
// - 'Creating interface' to 'maintain complex / primitive object uniformly', to 'separate' between 'leaf-node' & 'branch'
// - Composite has a connection of 'has-a' between object (composition of one or more familiar object that has similar function)

// Composite pattern: https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/original/academy/dos:6259f150d443195424de90190e320da820220110174445.jpeg
// - Composite: composite methods provider
// - Component: Declare object interface inside composite & apply suitable action (often is to access & manage composite component)
// - Leaf: Leaf object in a composite. Define primitive action
// - Client: Access object inside component, using component interface

/* INJECTION THEORY */
// IoC (Inversion of Control) is a programming principle that act as an invert flow control that is in contrary of traditional flow control
// - Commonly, a reusable code is used to do common task. In IoC, it uses to do specific task
// - Dependency Injection is one of the IoC implementation

// 'Dependency Injection' is a 'technique to use another class' 'without thinking how those class is being made'

// SOLID Principle has objective to increase sturdiness & maintenance ability of OOP & software component
// - Single Responsibility
// - Open/Closed
// - Liskov Substitution
// - Interface Segregation
// - Dependency Inversion

// Dependency Injection emphasize to write 'loosely coupled' & 'highly cohesion' code
// - Coupling: dependency measurement between 2 subsystems (a module could do its task when there is another module inside it)
// - Cohesion: dependency measurement inside 1 module (a method in 1 module handles only 1 task)

// it means that by Dependency Injection we are encouraged to:
// - loosen dependencies between modules, focusing on 1 module for 1 job

// example of Injection:
// - Constructor Injection:
/*
class Car(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

fun main(args: Array) {
    val engine = Engine()
    val car = Car(engine)
    car.start()
}
*/
// - Setter Injection:
/*
class Car {
    lateinit var engine: Engine

    fun start() {
        engine.start()
    }
}

fun main(args: Array) {
    val car = Car()
    car.engine = Engine()
    car.start()
}
*/

// Benefit using Dependency Injection:
// - helps Unit Testing
// - reduce boilerplate
// - easier to extends app
// - helps activating loose coupling
// - helps refactoring code

// 'Service Locator' is 'Dependency Injector alternative'
// - it loosen coupling between classes
// - it's being done by making class containing dependency that is needed, then use that class to call the dependency
/*
object ServiceLocator {
    fun getEngine(): Engine = Engine()
}

class Car {
    private val engine = ServiceLocator.getEngine()

    fun start() {
        engine.start()
    }
}

fun main() {
    val car = Car()
    car.start()
}
*/