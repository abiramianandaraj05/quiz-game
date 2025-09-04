public class Main {

    Main(){
        Model gameModel = new Model();
        View gameView = new View();

        gameView.setModel(gameModel);
        gameModel.setView(gameView);

        gameView.DisplayWelcomeScreen();


    }
    public static void main(String[] args){
        new Main();
    }
}
