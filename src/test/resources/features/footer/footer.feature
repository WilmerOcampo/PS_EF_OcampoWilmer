Feature: Interacción con los enlaces de redes sociales

  Background: Usuario autenticado en la página de inventario
    Given Estoy en la pagina de inventario

  Scenario: Hacer clic en el enlace de Twitter en el footer
    When Hago clic en el enlace de Twitter en el footer
    Then Seré redirigido a la página de Twitter
    And Vuelvo a la página de Saucedemo

  Scenario: Hacer clic en el enlace de Facebook en el footer
    When Hago clic en el enlace de Facebook en el footer
    Then Seré redirigido a la página de Facebook
    And Vuelvo a la página de Saucedemo

  Scenario: Hacer clic en el enlace de LinkedIn en el footer
    When Hago clic en el enlace de LinkedIn en el footer
    Then Seré redirigido a la página de LinkedIn
    And Vuelvo a la página de Saucedemo
