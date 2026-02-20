class ParkingSystem {
    int Big;
    int Medium;
    int Small;

    public ParkingSystem(int big, int medium, int small) {
        this.Big = big;
        this.Medium = medium;
        this.Small = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1 && Big != 0)
        {
            Big--;
            return true;
        }
         if(carType == 2 && Medium  != 0)
        {
            Medium--;
            return true;
        }
         if(carType == 3 && Small != 0)
        {
            Small--;
            return true;
        }
        else{
            return false;
        }
        
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
