package com.example.kannyf.anjirrapps.model

class PostData {
    var name : String = ""
    var comment : String = ""

    constructor(){}

    constructor(name : String, comment : String){
        this.name = name
        this.comment = comment
    }
}