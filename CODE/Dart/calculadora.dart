import 'dart:io';

void main() {
  print('Ingrese el primer número: ');
  double num1 = double.parse(stdin.readLineSync()!);

  print('Ingrese el segundo número: ');
  double num2 = double.parse(stdin.readLineSync()!);

  print('Seleccione una operación:');
  print('1. Suma');
  print('2. Resta');
  print('3. Multiplicación');
  print('4. División');

  int opcion = int.parse(stdin.readLineSync()!);

  double resultado = 0;

  switch (opcion) {
    case 1:
      resultado = num1 + num2;
      break;
    case 2:
      resultado = num1 - num2;
      break;
    case 3:
      resultado = num1 * num2;
      break;
    case 4:
      if (num2 == 0) {
        print('Error: No se puede dividir por cero.');
      } else {
        resultado = num1 / num2;
      }
      break;
    default:
      print('Opción inválida.');
      return;
  }

  print('El resultado es: $resultado');
}
