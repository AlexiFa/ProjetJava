public class Hotel extends Building {
    int nbRoom;
    public Hotel(){
        super();
    }

    public Hotel(String address, float livingSpace, int nbRoom) {
        super(address, livingSpace);
        this.nbRoom = nbRoom;
    }
}
