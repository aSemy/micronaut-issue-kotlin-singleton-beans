
Demo project for issue

> @Singleton Kotlin sealed/abstract superclass - subclasses are not available as beans
> https://github.com/micronaut-projects/micronaut-core/issues/5483

---


I investigated 5 scenarios - 

* A - Working - sealed class + @Singleton 'class' subclasses
* B - Not working - @Singleton sealed superclass + 'object declaration' subclasses
* C - Not working - @Singleton sealed superclass + 'class' subclasses
* D - Not working - sealed superclass + @Singleton  'object declaration' subclasses
* E - Not working - @Singleton abstract class superclass + 'class' subclasses

See `src/main/kotlin/com/example/HomePage.kt` for details

To experiment comment in/out the different arguments to explore each

```kotlin

@Controller
class HomePage(
  // ...
//  private val topics: List<TopicA>,
//  private val catFacts: CatFactsTopicA,
//  private val dogNews: DogNewsTopicA,
  /************************************************************/
  // ...
  private val topics: List<TopicB>,
  private val catFacts: CatFactsTopicB,
  private val dogNews: DogNewsTopicB,
  /************************************************************/
// ...
//  private val topics: List<TopicC>,
//  private val catFacts: CatFactsTopicC,
//  private val dogNews: DogNewsTopicC,
// ...
)
```

