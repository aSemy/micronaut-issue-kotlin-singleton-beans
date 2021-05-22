package com.example


import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get


@Controller
class HomePage(

  /************************************************************/
/*
*  A - Working - sealed class + @Singleton 'class' subclasses
 */
//  private val topics: List<TopicA>,
//  private val catFacts: CatFactsTopicA,
//  private val dogNews: DogNewsTopicA,

  /************************************************************/
/*
*
* B - Not working - @Singleton sealed superclass + 'object declaration' subclasses
*
* my preferred data structure
* - subclasses are singletons in code and in Micronaut
* - minimum definition (only one annotation required)
*
* Error:
* Message: No bean of type [com.example.CatFactsTopic] exists. Make sure the bean is not
* disabled by bean requirements (enable trace logging for
* 'io.micronaut.context.condition' to check) and if the bean is enabled then ensure
* the class is declared a bean and annotation processing is enabled (for Java and Kotlin
* the 'micronaut-inject-java' dependency should be configured as an annotation processor).
*/
  private val topics: List<TopicB>,
  private val catFacts: CatFactsTopicB,
  private val dogNews: DogNewsTopicB,

  /************************************************************/
/*
* C - Not working - @Singleton sealed superclass + 'class' subclasses
*/
//  private val topics: List<TopicC>,
//  private val catFacts: CatFactsTopicC,
//  private val dogNews: DogNewsTopicC,


  /************************************************************/
/*
* D - Not working - sealed superclass + @Singleton  'object declaration' subclasses
*
* Error:
* Message: class com.example.$DogNewsTopicDefinition tried to access private method
* 'void com.example.DogNewsTopic.<init>()' (com.example.$DogNewsTopicDefinition
* and com.example.DogNewsTopic are in unnamed module of loader 'app')
*/
//  private val topics: List<TopicD>,
//  private val catFacts: CatFactsTopicD,
//  private val dogNews: DogNewsTopicD,

  /************************************************************/
/*
* E - Not working - @Singleton abstract class superclass + 'class' subclasses
*/
//  private val topics: List<TopicE>,
//  private val catFacts: CatFactsTopicE,
//  private val dogNews: DogNewsTopicE,

  /************************************************************/

  ) {

  init {
    require(catFacts.displayName.contains("Cat"))
    require(dogNews.displayName.contains("sticks"))
  }

  @Get(
    uri = "/topics",
    produces = [MediaType.TEXT_PLAIN]
  )
  fun getTopics(): String {
    return topics.joinToString("\n")
  }

  @Get(
    uri = "/cats",
    produces = [MediaType.TEXT_PLAIN]
  )
  fun getCats(): String {
    return catFacts.toString()
  }

  @Get(
    uri = "/dogs",
    produces = [MediaType.TEXT_PLAIN]
  )
  fun getDogs(): String {
    return dogNews.toString()
  }
}
