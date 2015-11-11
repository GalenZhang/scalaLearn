package com.achievo.samples.user

/**
 * @author galen.zhang
 */
case class User(name: User)

trait UserRepository {
  def create(user: User)
  def find(name: String)
  def update(user: User)
  def delete(user: User)
}

class MockUserRepository extends UserRepository {
  def create(user: User) = println("create user: " + user)
  def find(name: String) = println("finding user: " + name)
  def update(user: User) = println("updating user: " + user)
  def delete(user: User) = println("deleting user: " + user)
}

class UserService {
  var userRepository: UserRepository = _
  def create(user: User) = userRepository.create(user)
  def find(name: String) = userRepository.find(name)
  def update(user: User) = userRepository.update(user)
  def delete(user: User) = userRepository.delete(user)
}

trait UserRepositoryComponent {
  val userRepository: UserRepository
}

trait UserServiceComponent {
  this: UserRepositoryComponent =>
  val userService: UserService
}

//object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
//  override val userRepository: UserRepository = new MockUserRepository
//  override val userService: UserService = new UserService(userRepository)
//  
//}


