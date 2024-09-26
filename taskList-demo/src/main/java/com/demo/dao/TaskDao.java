package com.demo.dao;

import com.demo.model.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TaskDao {
    private Connection getConnection() throws SQLException{
        String jdbcUrl = "jdbc:mysql://localhost:3306/taskDB";
        String jdbcName = "root";
        String jdbcPassword = "root";
        return DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPassword);
    }


    public void saveTask(Task task) throws SQLException{
        String sql = "INSERT INTO tasks (title, description, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getStatus());
            pstmt.executeUpdate();
        }
    }

    public List<Task> taskList() throws SQLException{
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setStatus(rs.getString("status"));
                tasks.add(task);
            }
            return tasks;
        }
    }

    public Task getTask(int id) throws SQLException{
        String sql = "SELECT * FROM tasks WHERE id=?";
        Task task = null;
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                    task = new Task();
                    task.setId(rs.getInt("id"));
                    task.setTitle(rs.getString("title"));
                    task.setDescription(rs.getString("description"));
                    task.setStatus(rs.getString("status"));
                }
            }
        }
        return task;
    }


    public void updateTask(Task task) throws SQLException{
        String sql = "UPDATE tasks SET title=?, description=?, status=? WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, task.getTitle());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getStatus());
            pstmt.setInt(4, task.getId());

            pstmt.executeUpdate();
        }
    }

    public void deleteTask(int id) throws SQLException{
        String sql = "DELETE FROM tasks WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
