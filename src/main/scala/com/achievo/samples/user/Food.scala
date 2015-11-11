package com.achievo.samples.user

/**
 * @author galen.zhang
 */
abstract class Food(val name: String) {
  override def toString = name
}

object Apple extends Food("Apple")
object Orange extends Food("Orange")
object Cream extends Food("Cream")
object Sugar extends Food("Sugar")

class Recipe(val name: String, val ingredients: List[Food], val instructions: String) {
  override def toString = name
}

trait Recipes {
  def allRecipes: List[Recipe]
}

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}

trait Foods {
  def allFoods: List[Food]
  def foodName(name: String) = allFoods.find(f => f.name == name)
}

abstract class Database extends FoodCategories with Recipes {

}

trait SimpleRecipes extends Recipes {
  object Pear extends Food("Pear")
  def allFods = List(Apple, Pear)
  def allCategories = Nil
}

