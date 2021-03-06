package com.codecool.snake.model;

import com.codecool.snake.model.common.GameEntityType;
import com.codecool.snake.model.common.ObservableEntity;

import static com.codecool.snake.common.Config.SNAKE_SPEED;

public class Entity extends ObservableEntity {
    private GameEntityType entityType;
    private boolean alive;
    private Shape bound;
    private int angle,
            speed = SNAKE_SPEED;

    public Entity() {
        this.alive = true;
        this.bound = new Shape(-100, -100, 0);
        this.angle = 0;
    }

    public Entity(Shape bound) {
        this.alive = true;
        this.bound = bound;
        this.angle = 0;
    }

    public GameEntityType getEntityType() {
        return entityType;
    }

    public Shape getShape() {
        return this.bound;
    }

    public int getAngle() {
        return this.angle;
    }

    protected void setEntityType(GameEntityType entityType) {
        this.entityType = entityType;
    }

    void setBounds(Shape newShape) {
        this.bound = newShape;
    }

    void setAngle(int angle) {
        this.angle = angle;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    boolean isAlive() {
        return alive;
    }

    protected void rotate(int rotateBy) {
        this.angle += rotateBy;
    }

    public void movement() {
        this.bound.moveTo(speed, this.angle);
        notifyAboutChange(this);
    }

    public void death() {
        System.out.println("==> ... Death of " + entityType);
        this.alive = false;
    }


}
