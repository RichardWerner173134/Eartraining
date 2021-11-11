package model;

public class CircleOfFifths {
    private static CircleOfFifths circleOfFifths;

    private CircleOfFifths(){
        initStuff();
    }

    public static CircleOfFifths getInstance(){
        if(circleOfFifths == null){
            circleOfFifths = new CircleOfFifths();
        }
        return circleOfFifths;
    }

    private void initStuff() {

    }
}
