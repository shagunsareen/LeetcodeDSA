class FooBar {
    private int n;
    private Semaphore semaphoreForFoo = new Semaphore(1); //because this should print first 
    private Semaphore semaphoreForBar = new Semaphore(0); //because this should not print intially 
    

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            semaphoreForFoo.acquire();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            semaphoreForBar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {  
        for (int i = 0; i < n; i++) {
            semaphoreForBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            semaphoreForFoo.release();
        }
    }
}