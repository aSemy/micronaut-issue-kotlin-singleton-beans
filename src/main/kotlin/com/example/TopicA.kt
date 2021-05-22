package com.example

import javax.inject.Singleton


/** A. Working - sealed class + @Singleton 'class' subclasses */
sealed class TopicA(
  val displayName: String
) {

  override fun toString(): String {
    return "${this::class.simpleName} - $displayName"
  }
}

@Singleton
class CatFactsTopicA : TopicA("Welcome to Cat Facts")

@Singleton
class DogNewsTopicA : TopicA("The latest in sticks")
