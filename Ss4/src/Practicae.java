class Practice {

    // Phuong thuc kiem tra so nguyen to
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    // Phuong thuc tinh so fibonacci thu n
    public static int fibonacci(int n){
        if(n < 0){
            throw new IllegalArgumentException("n khong duoc am");
        }

        if(n == 0) return 0;
        if(n == 1) return 1;

        int a = 0, b = 1;

        for(int i = 2; i <= n; i++){
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}