from Gobierno import Gobierno

salarioBruto = Gobierno.salario_bruto()
reteFuente = Gobierno.rete_fuente(salarioBruto)
salairoNeto  = Gobierno.salario_neto(salarioBruto, reteFuente)

print("Salario bruto:",salarioBruto,"\nRetencion en la fuente:",reteFuente,"\nSalario neto:",salairoNeto)