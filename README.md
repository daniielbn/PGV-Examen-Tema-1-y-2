# ENUNCIADO DEL EXAMEN
  Este examen está formado por una única parte práctica. Para hacer este examen se dispone de
  2 horas y se puede utilizar el internet y otro tipo de material para el examen, pero no se permite
  hablar ni comunicarse con ningún otro estudiante.
  Se deberá entregar un proyecto en Java con tantos paquetes como ejercicios haya en el
  examen. En cada paquete se resolverán los supuestos planteados en cada ejercicio. Si hay un
  ejercicio en C, también hay que entregar el fichero .c asociado.
  No se permite hablar ni compartir información con otros alumnos, en cuyo caso la nota del
  examen será un cero (0) para todos los implicados.
  Resuelve estos ejercicios que se plantean a continuación:

## 1. 
  Escribe un programa Java que lea palabras (sólo palabras, no frases) desde la entrada
  estándar y determine si cada palabra es "corta" (es decir, tiene 5 caracteres o menos).
  El programa debe imprimir cada palabra seguida de la indicación de si es corta o no. El
  programa leerá de la entrada estándar hasta leer “fin”. Al final, debe mostrar el número
  total de palabras cortas encontradas. Luego, escribe un programa que ejecute este
  programa (tras empaquetarlo en un .jar) usando ProcessBuilder , redirigiendo la entrada
  desde un archivo y la salida a otro archivo. (2p)
## 2. 
  Junto a este enunciado se adjunta un fichero de texto plano del Romancero Gitano, un
  conjunto de poemas del autor Federico García Lorca. Para honrar la memoria del poeta
  granadino, desde la RAE te piden que crees un programa en Java para contar cuantas
  vocales aparecen en el fichero adjunto. Para ello, te piden dos soluciones distintas, pero
  para las cuales tendrás siempre una clase Lector, la cual implementará la interfaz
  Runnable. Esta clase se encargará de leer del fichero, por lo que tendrá
  (obligatoriamente) como atributo un File apuntando al fichero de Lorca.
  De esta clase hay que crear tantos hilos como vocales haya que leer, los cuales
  accederán simultáneamente al fichero y contarán cuantas vocales hay. Cada hilo se
  encargará de contabilizar una única vocal. Esta operación de contar hay que hacerla
  de dos formas:
    # a. 
      Usando un vector de enteros para contabilizar cuantas vocales hay, cada vocal
      en una posición distinta. Por ejemplo, las veces que aparece la vocal ‘a’ se
      guardan en la posición 0, la ‘e’ en la posición 1… (2 p)
    # b. 
      Usando una variable estática a toda la clase que represente el número total de
      vocales, y otra que represente cuantas de ellas están en mayúsculas.(2 p)
  # Consideraciones:
     Hayy que realizar un launcher con una traza de ejecución lo más similar a las
    capturas mostradas arriba.
     Todos los hilos empiezan desde el principio del fichero, no hay que mover la
    línea de comienzo para ningún hilo.
     Cada hilo es encargado de contabilizar una única vocal
     Hay que usar métodos de sincronización en aquellos apartados en los que sea
    necesario.
## 3. 
  El Sweet Paradise es una pequeña y humilde cafetería vegana con una carta llena de
  postres y diferentes tipos de platos salados, entre ellos bocadillos.
  Las cocineras preparan diferentes tipos de bocadillos para los clientes que están
  esperando. Cada cliente tiene un tipo de bocadillo favorito (hummus, tofu o seitán) y solo
  quiere consumir su bocadillo preferido. Las chicas preparan los bocadillos y los colocan
  en la barra, donde los clientes pueden recogerlos si están disponibles y coinciden con su
  bocata favorito. Hay que simular este sistema creando estas clases:
    # a. 
      Bocadillo, que representa cada bocata vegano que se prepara. Cada bocata
      tiene un tipo (hummus, tofu o seitán) y un tamaño (grande o pequeño). Un bocata
      pequeño tarda 2 segundos en hacerse y en comerse, y uno grande son 5
      segundos.
    # b. 
      Mostrador, que representa el mostrador donde se ponen los bocatas y los
      clientes lo recogen. Sólo caben 5 bocatas. Hay que implementar estos métodos:
      # i. 
        boolean cogerBocata(Cliente c), que permite que un cliente coja un
        bocata del mostrador.Si hay bocatas, el cliente buscará que haya en el
        mostrador de su gusto, y lo cogerá, devolviendo true. Si no hay de su
        gusto, devolverá falso.
      # ii. 
        Public void ponerBocata(Bocadillo nuevoBocata, Cocinera c), que
        permite que la cocinera pueda añadir un bocata al mostrador siempre que
        haya espacio y haya veganos hambrientos.
    # c. 
      Cliente, que representa a un vegano hambriento. Tiene que implementar la
      interfaz Runnable. Cada cliente tiene un nombre y un bocata favorito. Los
      clientes intentan coger un bocata del mostrador de forma ordenada, revisarán si
      existe un bocata de su preferencia, y lo cogerán. Si no, se queda esperando a
      que las cocineras avisen. Si encuentran un bocata favorito, se lo comen y avisan
      a las cocineras para que lo preparen.
    # d. 
      Cocinera, que representa a las cocineras de la cafetería. También implementa la
      interfaz Runnable. Cada cocinera tiene un nombre, y se encarga de hacer
      bocatas y ponerlos en el mostrador. Cuando lo hacen, avisan al resto de clientes.
      Implementa esta simulación usando la clase ReentrantLock y Condition (4p)
    # Consideraciones:
       Cread un launcher con 2 cocineras y 5 clientes. Poned nombres automáticos:
      Cocinera 1, Cocinera 2, Cliente 4, Cliente 5…
       Antes de programar nada, paraos a pensar. ¿Cuántas secciones críticas hay?
       Para ajustarse a las necesidades de la asociación, debéis usar los métodos de
      sincronización que consideréis necesarios, y podéis añadir cualquier método,
      atributo o modificador a las clases mencionadas, aunque no se haya
      establecido en el enunciado.
       El acceso y salida al mostrador es en exclusión mutua total, es decir, si hay
      alguien entrando a echar un ojo a los bocatas, ya sea cocinero o cliente, nadie
      puede meter un bocata aunque haya otra persona sacando un bocata.
       Los clientes llegan para comerse 3 bocadillos, y las cocineras están trabajando
      todo el rato. Es decir, los clientes terminan, pero las cocineras no.
       El tiempo que cuesta hacer un bocata es el mismo que cuesta comérselo
       Puede ser que ocurra una condición de carrera en el que las cocineras hagan
      todos los bocatas del mismo sabor (tofu, por ejemplo), y los clientes tengan
      preferencias distintas. Es normal que ocurra hasta cierto punto, pero ceñíos al
      máximo a las especificaciones del enunciado.
