package com.example

import javax.inject.Singleton


/*
* Message: class com.example.$DogNewsTopicDefinition tried to access private method
* 'void com.example.DogNewsTopic.<init>()' (com.example.$DogNewsTopicDefinition
* and com.example.DogNewsTopic are in unnamed module of loader 'app')
*/

/** Not working - sealed superclass + @Singleton  'object declaration' subclasses */
sealed class TopicD(
  val displayName: String
) {

  override fun toString(): String {
    return "${this::class.simpleName} - $displayName"
  }
}

@Singleton
object CatFactsTopicD : TopicD("Welcome to Cat Facts")

@Singleton
object DogNewsTopicD : TopicD("The latest in sticks")
