# Selenium exercise 2

SELENIUM: Ejercicio 2 - Operaciones sobre distintos tipos de objetos

Objetivo: Aprender a trabajar con Selenium con diferentes objetos y diferentes tipos de operaciones.

Enunciado: Crear en un proyecto maven los diferentes test tomando como página base: http://the-internet.herokuapp.com/

Condicionantes:

-Cada página debe ser un page object

-Utilizar como mecanismo de reporting "Extent Report". Visitar https://github.com/extent-framework/extentreports-testng-adapter

-Todos los casos de test (@Test) deben estar contenidos en la misma clase ("runner").

-----------------------------------------------------------------------------------------

@Test1:

-Acceder a la opción "Chek boxes"

-Activar Check box 1 (solo si no está activado ya)

-Activar Check box 2 (solo si no está activado ya)

-----------------------------------------------------------------------------------------

@Test2:

-Aceder a la opción "Dynamic Content"

-Verificar que aparecen 3 iconos de perfiles

-Comprobar que aparece la imagen /img/avatars/Original-Facebook-Geek-Profile-Avatar-6.jpg

-Si no aparece, entonces el caso de prueba es "failed"

-Si aparece, entoces el caso de prueba es "passed"

-----------------------------------------------------------------------------------------

@Test3:

-Acceder a la opción "Horizontal Slider"

-Mover el slider hasta la posición 4,5

-----------------------------------------------------------------------------------------

@Test4:

-Acceder a la opción "JavaScript Alerts"

-Click en "Click for JS Prompt"

-Introducir un valor en cuadro de texto de la ventana y Aceptar

-Verificar que el valor introducido aparece en el la parte inferior de los botones

-----------------------------------------------------------------------------------------

@Test5:

-Acceder a la opción: "Dynamic Controls"

-Seleccionar la opción "Add"

-Seleccionar el Check que aparece

-----------------------------------------------------------------------------------------

@Test6:

-Acceder a la opción "Disappearing Elements"

-Hacer click en cada uno de los botones secuencialmente

-----------------------------------------------------------------------------------------

@Test7:

-Acceder a la opción "Challenging DOM"

-Si existen al menos un botón "foo" hacer click en uno de ellos. En caso contrario hacer click en alguno de los botones que contengar "baz"

- Recorrer la tabla que aparece en la parte de derecha por filas y mostrar el resultado por consola.

-----------------------------------------------------------------------------------------

@Test8:

-Acceder a la opción "Multiple Windows"

-Comprobar que el mensaje que aparece en la nueva ventana es: New Window"
