package com.demo.action;

import com.demo.dao.TaskDao;
import com.demo.model.Task;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;

public class TaskAction extends ActionSupport {

    private int id;
    private String title;
    private String description;
    private String status;
    private List<Task> tasks;
    private TaskDao taskDao = new TaskDao();

    public String list(){
        try {
            tasks = taskDao.taskList();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String add(){
        if (title != null && description != null && status !=null){
            Task task = new Task();
            task.setTitle(title);
            task.setDescription(description);
            task.setStatus(status);
            try {
                taskDao.saveTask(task);
            } catch (SQLException e){
                e.printStackTrace();
            }
            return SUCCESS;
        }
        return INPUT;
    }

    public String edit(){
        if (id > 0){
            try {
                Task task = taskDao.getTask(id);
                if (task != null){
                    task.setTitle(title);
                    task.setDescription(description);
                    task.setStatus(status);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return INPUT;
    }

    public String delete() {
        try {
            taskDao.deleteTask(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
