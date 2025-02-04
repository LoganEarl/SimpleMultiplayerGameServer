package client.model;

import java.awt.*;

public class Player implements GameObject {
    private EntityData pData;
    private Vector2D vel, dim, spawnPoint, lastPos;
    private Color col;
    private float speed;
    private boolean grounded = false;

    public Player(EntityData entityData, Color color, Vector2D dimensions) {
        this.pData = entityData;
        this.vel = new Vector2D(0, 0);
        this.dim = dimensions;
        this.speed = 0.5f;
        this.col = color;
        this.spawnPoint = new Vector2D(entityData.getPos().getX(), entityData.getPos().getY());
    }

    @Override
    public void update(float dtMod) {
        this.pData.getPos().setXY(this.pData.getPos().getX() + (this.vel.getX() * dtMod), this.pData.getPos().getY() + (this.vel.getY() * dtMod));
        this.vel.scale(1f - (0.02f * dtMod) );
        this.vel.addXY(0, 0.7f * dtMod);
        this.grounded = false;
    }
    public void updateAsGhost(float dtMod) {
        this.pData.getPos().setXY(this.pData.getPos().getX() + (this.vel.getX() * dtMod), this.pData.getPos().getY() + (this.vel.getY() * dtMod));
        this.vel.scale(1f - (0.02f * dtMod));
    }
    @Override
    public Vector2D getVelocity() {
        return vel;
    }
    @Override
    public Vector2D getDim() {
        return dim;
    }
    @Override
    public Vector2D getPos() {
        return this.pData.getPos();
    }
    public EntityData getPlayerData() {return this.pData; }
    public void setPlayerData(EntityData newData) {
        this.pData.setPos(newData.getPos());
        this.pData.setId(newData.getId());
    }
    public Color getColor() {
        return this.col;
    }
    public void setVel(Vector2D vel) {
        this.vel.setXY(vel.getX(), vel.getY());
    }
    public void setPos(Vector2D pos) {this.pData.getPos().set(pos); }
    public float getSpeed() {
        return speed;
    }
    public void setSpeed(float speed) {
        this.speed = speed;
    }
    public void setGrounded(boolean state) {
        this.grounded = state;
    }
    public boolean getGrounded() {
        return this.grounded;
    }
    public void respawn() {this.setPos(this.spawnPoint); this.getVelocity().setXY(0, 0);}
    public Vector2D getSpawnPoint() {return this.spawnPoint; }
    public void setSpawnPoint(Vector2D spawnPoint) {this.spawnPoint = spawnPoint;}
}
