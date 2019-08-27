# AL-xicoDeSQL
Analizador de Léxico de Mini-SQL utilizando JFlex

# Funcionamiento

-Al ejecutar el programa, la primera acción que este realiza, es llamar a la función "generate" del Main de la librería JFLEX,
la cual genera (crea o sobreescribe) un archivo Lexer.java con las propiedades y funciones generadas por jflex a partir de un
archivo Lexer.flex el cual contiene una estructura definida y ordenada, con las reglas de léxico que definen al lenguaje.
Con dichas reglas formadas a partir de expresiones regulares, se puede "encasillar" o clasificar cierta cadena obtenida de un archivo
externo en un "Token".

-El programa es completamente intuitivo, tiene un área para elegir el archivo .sql a Analizar y un botón para iniciar el análisis.

-El análisis del archivo es realizado por la clase Lexer.java generada, La cual va retornando los Tokens y la información solicitad
en el Lexer.flex (en este caso información, como el texto de la cadena, la linea del archivo en donde se encuentra y el
número de "columna" donde esta empieza y termina)
-Dependiendo del Token que se retorne se realiza cierta acción (por ejemplo con los errores que son mandados a un Text Area para poder
visualizarlos en pantalla).
-Los Tokens y su información son almacenados en un archivo .out con el mismo nombre del archivo de entrada .sql elegido y en su mismo
directorio.

# Como se manejan los errores

-En el caso de las palabras reservadas e identificadores no se manejan errores, por ejemplo si encuentro la cadena "_danilo" o "78alex"
no lo maneja como un error de identificador, simplemente lo detecta como un entero u operador seguido de un identificador.
