class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        /*int n = position.length;
        double[][] cars = new double[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double lastTime = 0.0;

        for(int i=0; i<n; i++){
            double time = (target - cars[i][0])/cars[i][1];
            if(time > lastTime){
                fleets++;
                lastTime = time; //slowest time and other cars can see if they complete target in lesser time than this or not 
            }
        }

        return fleets;*/

        //using stack 
        int n = position.length;
        double[][] cars = new double[n][2];

        for(int i=0; i<n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0])); //sort by position desc

        Stack<Double> stack = new Stack<>();

        for(int i=0; i<n; i++){
            double pos = cars[i][0];
            double spd = cars[i][1];
            double time = (target - pos)/spd;

            if(stack.isEmpty() || stack.peek() < time){
                stack.push(time); //new fleet else merges with fleet ahead
            }
        }
        return stack.size();
    }
}