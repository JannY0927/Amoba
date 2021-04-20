package hu.alkfejl1.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PlayedGame {
    /*
    --Lépés azonosító
    --játék azonosítá
    --lépés x
    --lépés y
    --jel
    */

    private IntegerProperty stepId = new SimpleIntegerProperty(this,"stepId");
    private IntegerProperty gameId = new SimpleIntegerProperty(this,"gameId");
    private IntegerProperty stepX = new SimpleIntegerProperty(this,"stepX");
    private IntegerProperty stepY = new SimpleIntegerProperty(this,"stepY");
    private StringProperty signValue = new SimpleStringProperty(this,"signValue");

    public int getStepId() {
        return stepId.get();
    }

    public IntegerProperty stepIdProperty() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId.set(stepId);
    }

    public int getGameId() {
        return gameId.get();
    }

    public IntegerProperty gameIdProperty() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId.set(gameId);
    }

    public int getStepX() {
        return stepX.get();
    }

    public IntegerProperty stepXProperty() {
        return stepX;
    }

    public void setStepX(int stepX) {
        this.stepX.set(stepX);
    }

    public int getStepY() {
        return stepY.get();
    }

    public IntegerProperty stepYProperty() {
        return stepY;
    }

    public void setStepY(int stepY) {
        this.stepY.set(stepY);
    }

    public String getSignValue() {
        return signValue.get();
    }

    public StringProperty signValueProperty() {
        return signValue;
    }

    public void setSignValue(String signValue) {
        this.signValue.set(signValue);
    }
}
