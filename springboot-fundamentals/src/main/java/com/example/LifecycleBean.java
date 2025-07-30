package com.example;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean implements SmartLifecycle {
    
    private boolean running = false;
    
    @Override
    public void start() {
        System.out.println("=== LifecycleBean.start() called ===");
        running = true;
    }
    
    @Override
    public void stop() {
        System.out.println("=== LifecycleBean.stop() called ===");
        running = false;
    }
    
    @Override
    public boolean isRunning() {
        return running;
    }
    
    @Override
    public boolean isAutoStartup() {
        return true;
    }
    
    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }
    
    @Override
    public int getPhase() {
        return 0;
    }
} 