package com.example

import javax.inject.Singleton

/** Not working - @Singleton abstract class superclass + 'class' subclasses */
@Singleton
abstract class TopicE(
  val displayName: String
) {

  override fun toString(): String {
    return "${this::class.simpleName} - $displayName"
  }
}

class CatFactsTopicE : TopicE("Welcome to Cat Facts")

class DogNewsTopicE : TopicE("The latest in sticks")

/*
* Message: No bean of type [com.example.CatFactsTopic] exists.
* Make sure the bean is not disabled by bean requirements
* (enable trace logging for 'io.micronaut.context.condition'
* to check) and if the bean is enabled then ensure the class
* is declared a bean and annotation processing is enabled (for
* Java and Kotlin the 'micronaut-inject-java' dependency should
* be configured as an annotation processor).
*/
