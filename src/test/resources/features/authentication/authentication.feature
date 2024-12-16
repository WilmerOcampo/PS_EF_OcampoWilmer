Feature: Verificar las credenciales y navegar a diferentes páginas en el sitio web Saucedemo

  Background: Configuración inicial del navegador
    Given Estoy en la página de inicio de sesión

  Scenario Outline: Acceder a la página de inventario desde la página de inicio de sesión
    When Ingreso el username <username> y password "secret_sauce"
    And Hago clic en el botón de inicio de sesión
    Then Accederé a la página de inventario

    Examples:
      |        username         |
      |"standard_user"          |
      |"problem_user"           |
      |"performance_glitch_user"|

  Scenario: Permanecer en la página de inicio de sesión debido a un username incorrecto
    When Ingreso un username incorrecto y password válido
    And Hago clic en el botón de inicio de sesión
    Then Permanezco en la página de inicio de sesión

  Scenario: Permanecer en la página de inicio de sesión debido a un password incorrecto
    When Ingreso username válido y un password incorrecto
    And Hago clic en el botón de inicio de sesión
    Then Permanezco en la página de inicio de sesión