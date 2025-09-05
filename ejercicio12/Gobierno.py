class Gobierno:
    def salario_bruto():
        valor = float(input("Valor hora: "))
        horas = int(input("Horas trabajadas: "))
        bruto = horas * valor
        return bruto

    def rete_fuente(salario):
        retencion = salario * 0.125
        return retencion
    
    def salario_neto(salario, retencion): 
        neto = salario - retencion
        return neto