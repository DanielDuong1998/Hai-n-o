package com.ss.effects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.ss.assetManager.XAssetsManager;

public class effectWin extends Actor{
    private static FileHandle fireWork = Gdx.files.internal("particle/firework");
    private static FileHandle fireWork1 = Gdx.files.internal("particle/fireWork1");
    //private static FileHandle light = Gdx.files.internal("particle/win");
//    private static FileHandle BossDie = XAssetsManager.getParticleEffectPool("kill_bomb");
    boolean dispose ;

    public ParticleEffect effect;
    private Actor parent = this.parent;
    private Group stage;

    public effectWin(int id, float x, float y,boolean dispose) {
        this.dispose = dispose;
        this.effect = new ParticleEffect();
        //particleEffect = new ParticleEffectCustom();
        //initFileHandle();
        setX(x);
        setY(y);
            if(id==1){
                this.effect.load(fireWork, Gdx.files.internal("particle"));
                this.effect.scaleEffect(2.0f);
                for (int i = 0; i < this.effect.getEmitters().size; i++) {
                    ((ParticleEmitter) this.effect.getEmitters().get(i)).flipY();
                    ((ParticleEmitter) this.effect.getEmitters().get(i)).setFlip(true,false);
                }
            }
            else if(id == 2){
                this.effect.load(fireWork1, Gdx.files.internal("particle"));
//               this.effect. XAssetsManager.getParticleEffectPool("kill_bomb");
//                this.effect.load(XAssetsManager.getParticleEffectPool("kill_bomb"), Gdx.files.internal("particle"));
                this.effect.scaleEffect(2.0f);
                for (int i = 0; i < this.effect.getEmitters().size; i++) {
                    ((ParticleEmitter) this.effect.getEmitters().get(i)).flipY();
                    ((ParticleEmitter) this.effect.getEmitters().get(i)).setFlip(true,false);
                }
            }
//            else if(id == 3){
//                this.effect.load(light, Gdx.files.internal("particle"));
////               this.effect. XAssetsManager.getParticleEffectPool("kill_bomb");
////                this.effect.load(XAssetsManager.getParticleEffectPool("kill_bomb"), Gdx.files.internal("particle"));
//                this.effect.scaleEffect(2.0f);
//                for (int i = 0; i < this.effect.getEmitters().size; i++) {
//                    ((ParticleEmitter) this.effect.getEmitters().get(i)).flipY();
//                    ((ParticleEmitter) this.effect.getEmitters().get(i)).setFlip(true,false);
//                }
//            }

        this.effect.setPosition(x, y);
    }

    public void act(float f) {
        super.act(f);
        this.effect.setPosition(getX(), getY());
        this.effect.update(f);
    }

    public void draw(Batch batch, float f) {
        super.draw(batch, f);
        if (!this.effect.isComplete()) {
            this.effect.draw(batch);
            return;
        }
        if(dispose)
            this.effect.dispose();
    }

    public void start() {
        this.effect.start();
    }

    private void initFileHandle(){
//        nextLv = particleEffect.getNextLv();
//        BossDie = particleEffect.getBossDie();
    }
}
