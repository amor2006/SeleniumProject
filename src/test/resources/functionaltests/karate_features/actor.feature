Feature: Actors

  Background: 
    * call read('classpath:karate_features/actor.feature')
    * def actorJson = read('classpath:karate_package/actor.json')

  Scenario: Posting Actor
    Given url baseUrl + 'actor'
    Then method get
    * print response
