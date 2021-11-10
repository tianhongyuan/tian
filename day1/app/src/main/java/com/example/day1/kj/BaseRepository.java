package com.example.day1.kj;

import java.lang.reflect.Field;


public abstract class BaseRepository {

    public BaseRepository() {
        injectModel();
    }

    private void injectModel(){
        Class<? extends BaseRepository> aClass = this.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        if(declaredFields.length == 0){
            throw new RuntimeException("没有匹配的");
        }
        boolean falg = false;
        for (Field declaredField : declaredFields) {
            Model annotation = declaredField.getAnnotation(Model.class);
            if(null != annotation){
                declaredField.setAccessible(true);
                falg = true;
                String name = declaredField.getType().getName();
                try {
                    Class<?> aClass1 = Class.forName(name);
                    Object o = aClass1.newInstance( );
                    declaredField.set(this,o);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        if(!falg){
            throw new RuntimeException("没有model");
        }
    }
}
