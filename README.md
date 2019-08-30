# AL-xicoDeSQL
Analizador de Léxico de Mini-SQL utilizando JFlex

# Funcionamiento

- Al ejecutar el programa, la primera acción que este realiza, es llamar a la función "generate" del Main de la librería JFLEX,
la cual genera (crea o sobreescribe) un archivo Lexer.java con las propiedades y funciones generadas por jflex a partir de un
archivo Lexer.flex el cual contiene una estructura definida y ordenada, con las reglas de léxico que definen al lenguaje.
Con dichas reglas formadas a partir de expresiones regulares, se puede "encasillar" o clasificar cierta cadena obtenida de un archivo
externo en un "Token".

- El programa es completamente intuitivo, tiene un área para elegir el archivo .sql a Analizar y un botón para iniciar el análisis.

- El análisis del archivo es realizado por la clase Lexer.java generada, La cual va retornando los Tokens y la información solicitad
en el Lexer.flex (en este caso información, como el texto de la cadena, la linea del archivo en donde se encuentra y el
número de "columna" donde esta empieza y termina)
- Dependiendo del Token que se retorne se realiza cierta acción (por ejemplo con los errores que son mandados a un Text Area para poder
visualizarlos en pantalla).
-Los Tokens y su información son almacenados en un archivo .out con el mismo nombre del archivo de entrada .sql elegido y en su mismo
directorio.

# Como se manejan los errores

- En el caso de las palabras reservadas e identificadores no se manejan errores, por ejemplo si encuentro la cadena "_danilo" o "78alex"
no lo maneja como un error de identificador, simplemente lo detecta como un entero u operador seguido de un identificador.

- Los caracteres 1 y 0 sin más, por razones de presedencia los toma como un tipo de dato Bit, para el resto de enteros los toma como tal.
Pero si un número con tiene un dígito seguido de un punto, se empiezan a validar como tipos de dato Float.

- Para los float se validan 3 errores; que no hayan dígitos antes del punto, que exista un exponencial, pero no dígitos después de él, y la combinación de estas 2 excepeciones
- segun el enunciado, Para la base del Float, no se toma en cuenta un signo, sin embargo, yo lo tomo en cuenta, tanto para la base como para el exponente.
- la existencia de un punto decimal en el exponente no se tomaría como parte del float, sino como un signo de puntuación

- En el caso de los String se maneja el caso de tomar en cuenta todos los caracteres excepto los saltos de línea, si se encuantra un salto de línea antes que un apóstrofe, se muestra dicho error.
- Por presedencia primero se toma en cuenta todas aquellas cadenas compuestas de cualquier caracter exceptuando los saltos de linea,
todo ello seguido de una apóstrofe obligatoria. De modo que al encontrar un salto de línea antes, pasa a la excepción.
La excepción maneja todos aquellos caracteres después de un apóstrofe que no son ni una apóstrofe misma, ni un salto de línea,
seguido de un salto de línea o simplemte nada, como en el caso de que este se encuentre al final del archivo.

- El comentario simple toma en cuenta los caracteres "--" seguidos de cualquier otro caracter excepto el salto de línea, de modo que al encontrar un salto de línea, el resto ya no se toma como un comentario.

- De la misma forma con los comentarios multilínea, se toman en cuenta todas aquellas cadenas que empiezen por / y * seguido de
caracteres cualesquiera y finalizado por * y /
- En dicha regla al descartar todo lo que venga adentro como un /* repetido no afectaría
- Un (* y /) por si sólo los detectaría como dos símbolos. Por lo que la existencia de comentarios multilinea completamente anidados
no existiría
- En cambio un /* por sí solo si es tomado como una expresión aparte, pues al no contener un cierre de comentario, no cumple con la expresión regular anterior, por lo que esos caracteres por sí solos representan el error de comentario sin cerrar. De ese mismo modo se puede seguir analizando las cadenas que vengan después de este.

#Recordatorio
- únicamente para acordarme de lo que debo corregir en un futuro

No tomar en cuenta los casos específicos de error en los "FLOAT"
- ejemplo:
.12E123 al no corresponder a la expresión regular de float, debe separarlo en <.> símbolo, <12> int, <E123> Identifiador.
  
  


