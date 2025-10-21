function calc(op, a, b) {
  switch (op) {
    case '+':
      return a + b;

    case '-':
      return a - b;

    case '*':
      return a * b;

    case '/':
      return b === 0 ? 'Division by zero' : a / b;

    case 'mod':
      return b === 0 ? 'Modulo by zero' : a % b;

    case 'pow':
      return Math.pow(a, b);

    case 'log':
      return Math.log(a) / Math.log(b);

    default:
      return 'Invalid operator';
  }
}

console.log(calc('+', 2, 3));
console.log(calc('pow', 2, 5));
console.log(calc('log', 100, 10));
console.log(calc('/', 10, 0));
console.log(calc('xyz', 1, 2));
