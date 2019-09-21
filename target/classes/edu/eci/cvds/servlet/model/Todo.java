/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.servlet.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2118887
 */
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    public Todo(){
    }
    
    public void setUserId (int userId){
        this.userId= userId;
    }
    
    public void setId (int id){
        this.id= id;        
    }
    public void setTitle (String title){
        this.title=title;        
    }
    
    public void setCompleted (boolean completed){
        this.completed= completed;
    }
    
    public int getUserId (){
        return userId;
    }
    
    public int getId (){
        return id;
    }
    
    public String getTitle(){
        return title;        
    }
    
    public boolean getCompleted(){
        return completed;
    }
}