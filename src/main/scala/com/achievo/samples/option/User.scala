package com.achievo.samples.option

/**
 * @author galen.zhang
 */
case class User(id: Int, firstName: String, lastName: String, age: Int, gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None))

  def findById(id: Int): Option[User] = users.get(id)

  def findAll = users.values

  def main(args: Array[String]): Unit = {
    val user1 = UserRepository.findById(1)
    if (user1.isDefined) {
      println(user1.get.firstName)
    }

    val user = User(2, "Johanna", "Doe", 30, None)
    println("Gender: " + user.gender.getOrElse("not specified"))

    val gender = user.gender match {
      case Some(gender) => gender
      case None => "not specified"
    }
    println("Gender: " + gender)

    UserRepository.findById(2).foreach(user => println(user.firstName))

    val age = UserRepository.findById(1).map(_.age)
    println(age)

    val gender5 = UserRepository.findById(1).map(_.gender)
    println(gender5)

    val gender1 = UserRepository.findById(1).flatMap(_.gender) // gender is Some("male")
    val gender2 = UserRepository.findById(2).flatMap(_.gender) // gender is None
    val gender3 = UserRepository.findById(3).flatMap(_.gender) // gender is None
    println(gender1 + "\n" + gender2 + "\n" + gender3)

    val names: List[List[String]] =
      List(List("John", "Johanna", "Daniel"), List(), List("Doe", "Westheide"))
    println(names.map(_.map(_.toUpperCase)))
    // results in List(List("JOHN", "JOHANNA", "DANIEL"), List(), List("DOE", "WESTHEIDE"))
    println(names.flatMap(_.map(_.toUpperCase)))
    // results in List("JOHN", "JOHANNA", "DANIEL", "DOE", "WESTHEIDE")

    val namesO: List[Option[String]] = List(Some("Johanna"), None, Some("Daniel"))
    println(namesO.map(_.map(_.toUpperCase))) // List(Some("JOHANNA"), None, Some("DANIEL"))
    println(namesO.flatMap(xs => xs.map(_.toUpperCase))) // List("JOHANNA", "DANIEL")

    UserRepository.findById(1).filter(_.age > 30) // None, because age is <= 30
    UserRepository.findById(2).filter(_.age > 30) // Some(user), because age is > 30
    UserRepository.findById(3).filter(_.age > 30) // None, because user is already None

    val gender4 = for {
      user <- UserRepository.findById(1)
      gender <- user.gender
    } yield gender // results in Some("male")
    println(gender4)

    val genderSeq = for {
      user <- UserRepository.findAll
      gender <- user.gender
    } yield gender // result in List("male")
    println(genderSeq)

    val genderFor = for {
      User(_, _, _, _, Some(gender)) <- UserRepository.findAll
    } yield gender
    println(genderFor)

    case class Resource(content: String)
    val resourceFromConfigDir: Option[Resource] = None
    val resourceFromClasspath: Option[Resource] = Some(Resource("I was found on the classpath"))
    val resource = resourceFromConfigDir orElse resourceFromClasspath
  }
}