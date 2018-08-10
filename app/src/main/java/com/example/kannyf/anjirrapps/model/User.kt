package com.example.kannyf.anjirrapps.model

class User {
    constructor(int: Int, string: String?, string1: String?, string2: String?)

    private var id: Int = 0
    private var email: String = ""
    private var name: String = ""
    private var school: String = ""

    fun User(id: Int, email: String, name: String, school: String) {
        this.id = id
        this.email = email
        this.name = name
        this.school = school
    }

    fun getId(): Int {
        return id
    }

    fun getEmail(): String {
        return email
    }

    fun getName(): String {
        return name
    }

    fun getSchool(): String {
        return school
    }
}