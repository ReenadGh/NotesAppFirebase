package com.example.noteappfirebase2

import com.google.firebase.firestore.Exclude

data class Note( val  id : String , val noteDes : String  ){

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "noteId" to id,
            "noteDes" to noteDes,
        )
    }
}
