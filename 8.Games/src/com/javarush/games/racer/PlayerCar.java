package com.javarush.games.racer;

public class PlayerCar extends GameObject {

    private static int playerCarHeight = ShapeMatrix.PLAYER.length;

    public PlayerCar() {
        super(RacerGame.WIDTH / 2 + 2, RacerGame.HEIGHT - playerCarHeight - 1, ShapeMatrix.PLAYER);
    }
}
