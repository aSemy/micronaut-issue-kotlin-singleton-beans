package com.example

import javax.inject.Singleton


@Singleton
sealed class TopicC(
  val displayName: String
) {

  override fun toString(): String {
    return "${this::class.simpleName} - $displayName"
  }
}

class CatFactsTopicC : TopicC("Welcome to Cat Facts")

class DogNewsTopicC : TopicC("The latest in sticks")
