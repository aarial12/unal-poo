from instrucciones import *

suma = int(input("Ingrese el valor para 'suma': "))
x = int(input("Ingrese el valor para X: "))

suma = Instrucciones.operacion_1(suma, x)

y = int(input("Ingrese el numero para Y: "))

x = Instrucciones.operacion_2(x, y)

suma = Instrucciones.operacion_3(suma, x, y)

print("El valor de la suma es:", suma)