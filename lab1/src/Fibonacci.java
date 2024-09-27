public class Fibonacci {
    private int index;
    private long value;

    public Fibonacci(int index) {
        this.index = index;
        this.value = calculateFibonacci(index);
    }

    private long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        long prev1 = 1, prev2 = 0;
        long fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = prev1 + prev2;
            prev2 = prev1;
            prev1 = fib;
        }
        return fib;
    }

    public boolean checkInequality() {
        long fibNplus2 = calculateFibonacci(this.index + 2);
        long powerOfTwo = (long) Math.pow(2, this.index);
        return fibNplus2 < powerOfTwo;
    }

    public void displayResults() {
        System.out.println("Число Фібоначчі F(" + this.index + ") = " + this.value);
        System.out.println("Перевірка нерівності F(" + (this.index + 2) + ") < 2^" + this.index + ": "
                + (checkInequality() ? "Виконується" : "Не виконується"));
    }
}
