package com.example.kannyf.anjirrapps.model

class PostData {
    var name : String = ""
    var comment : String = ""
    var image : Int? = 1

    constructor(){}

    constructor(name : String, comment : String){
        this.name = name
        this.comment = comment
        this.image = image
    }
}