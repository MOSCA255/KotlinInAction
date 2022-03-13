package kotlininaction.episode3.user

import java.lang.IllegalArgumentException

class User( val id : Int, val name : String, val address : String)

fun saveUser(user : User){
    if (user.name.isEmpty()){
        throw IllegalArgumentException( "Can't save user ${user.id} : empty Name")
    }
    if (user.address.isEmpty()){
        throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
    }

}

fun saveUser_2(user : User){
    fun validate(user : User, value: String, filedName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException( "Can't save user ${user.id}: empty $filedName")
        }
    }
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUser_3(user : User){
    fun validate(value: String, filedName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException( "Can't save user ${user.id}: empty $filedName")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun User.validateBeforeSave(){ // 확장함수로 호출
     fun validate(value: String, filedName: String){
        if(value.isEmpty()){
            throw IllegalArgumentException( "Can't save user $id: empty $filedName")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

fun main() {
    //saveUser(User(1, "",""));

    //saveUser_2(User(1, "", ""))

    User(1, "t", "").validateBeforeSave()
}