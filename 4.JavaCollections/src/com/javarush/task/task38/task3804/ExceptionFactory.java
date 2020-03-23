package com.javarush.task.task38.task3804;

public class ExceptionFactory {

  public static Throwable getException(Enum<?> e){
      if(e instanceof ApplicationExceptionMessage) {
          return new Exception(e.name().replaceAll("_"," ").toLowerCase().replaceFirst(String.valueOf(e.name().toLowerCase().charAt(0)),
                  String.valueOf(e.name().charAt(0))));
      }
      if(e instanceof DatabaseExceptionMessage) {
          return new RuntimeException(e.name().replaceAll("_"," ").toLowerCase().replaceFirst(String.valueOf(e.name().toLowerCase().charAt(0)),
                  String.valueOf(e.name().charAt(0))));
      }
      if(e instanceof UserExceptionMessage) {
          return new Error(e.name().replaceAll("_"," ").toLowerCase().replaceFirst(String.valueOf(e.name().toLowerCase().charAt(0)),
                  String.valueOf(e.name().charAt(0))));
      }

      return new IllegalArgumentException();
  }


}
