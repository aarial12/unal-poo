from calculadora_edad import Calculos
#no se manda al correo institucional, se manda a ia.walterarboleda@gmail.com
edad_juan = int(input("Ingrese la edad de Juan: "))

edad_alberto = Calculos.calcular_alberto(edad_juan)
edad_ana = Calculos.calcular_ana(edad_juan)
edad_mama = Calculos.calcular_mama(edad_juan, edad_alberto, edad_ana)

print("Alberto tiene",edad_alberto,"años.")
print("Ana tiene", edad_ana, "años.")
print("La madre de los 3 tiene", edad_mama,"años.")