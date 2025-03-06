#language: es

@TAG-FEATURE
Característica: Consumo básico de un servicio con método PUT

  @TAG-TES01
  Esquema del escenario: <testId> Consumo der servicio con método PUT Básico
    Dado que se genera la informacion necesaria para el consumo del servicio put
      | name   | job   |
      | <name> | <job> |
    Cuando se realiza el consumo del servicio
      | user   |
      | <user> |
    Entonces Debe responder de manera correcta
      | name   | job   | id   | updatedAt   | statusResponse   |
      | <name> | <job> | <id> | <updatedAt> | <statusResponse> |
    Ejemplos:
      | testId    | user | name  | job         | id | updatedAt | statusResponse |
      | testId001 | 2    | User  | Automation2 | OK | OK        | 200            |
      #| testId002 | 2    | null  | Automation  | NA | NA        | 200            |
      #| testId003 | 2    | empty | Automation  | NA | NA        | 200            |
      #| testId004 | 2    | User  | null        | NA | NA        | 200            |
      #| testId005 | 2    | User  | empty       | NA | NA        | 200            |
