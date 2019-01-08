package com.example.user.sqlite

class User {
    var id:Int=0
    lateinit var name:String
    var age:Int=0
    constructor()
    constructor(id:Int,name:String,age:Int)
    {
        this.id=id
        this.name=name
        this.age=age
    }

    override fun toString(): String {
        return " ID: $id name: $name age:$age"
    }
}