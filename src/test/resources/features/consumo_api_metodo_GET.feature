#language: es

@TAG-FEATURE
Característica: Consumo básico de un servicio con método GET

  @TAG-TES01
  Esquema del escenario: <testId> Consumo der servicio con método GET Básico
    Dado que se genera la informacion necesaria para el consumo del servicio
    Cuando se realiza el consumo del servicios con los parametros
      | page   |
      | <page> |
    Entonces Debe responder de manera correcta con datos
      | page   | pageResponse   | per_page   | total   | total_pages   | data   | support   | url   | text   | statusResponse   |
      | <page> | <pageResponse> | <per_page> | <total> | <total_pages> | <data> | <support> | <url> | <text> | <statusResponse> |
    Ejemplos:
      | page | pageResponse | per_page | total | total_pages | data | support | url                                                                             | text                                                                                  | statusResponse |
      | 2    | 2            | 6        | 12    | 2           | OK   | OK      | https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral | Tired of writing endless social media content? Let Content Caddy generate it for you. | 200            |