package com.example.test.demo.Models;

public class ResponseObject {
    private  String status ;
    private String messager;
    private  Object data;
    public  ResponseObject (){

    }
    public ResponseObject(String status , String messager , Object data){
        this.data= data ;
         this.status= status ;
          this.messager = messager ;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessager() {
        return messager;
    }

    public void setMessager(String messager) {
        this.messager = messager;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
