package com.example

import javax.inject.Singleton


/**
 * B. is my preferred data structure
 * - subclasses are singletons in code and in Micronaut
 * - minimum definition (only one annotation required)
 */
@Singleton
sealed class TopicB(
  val displayName: String
) {

  override fun toString(): String {
    return "${this::class.simpleName} - $displayName"
  }
}

object CatFactsTopicB : TopicB("Welcome to Cat Facts")

object DogNewsTopicB : TopicB("The latest in sticks")
