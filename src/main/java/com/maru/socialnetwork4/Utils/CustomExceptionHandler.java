package com.maru.socialnetwork4.Utils;

public class CustomExceptionHandler extends Exception{
    CustomExceptionHandler(){
        super();
    }

    CustomExceptionHandler(String message){
        super(message);
    }
}
