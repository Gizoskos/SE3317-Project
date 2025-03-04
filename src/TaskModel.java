import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskModel implements Subject {
    List<Observer> observerList = new ArrayList<>();


    @Override
    public void addTask(Task task) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO tasks (task_name, description, category, deadline) VALUES (?, ?, ?, ?)")) {
            pstmt.setString(1, task.getName());
            pstmt.setString(2, task.getDescription());
            pstmt.setString(3, task.getCategory());
            pstmt.setString(4, task.getDeadline());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteTask(String taskName) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tasks WHERE task_name = ?")) {
            pstmt.setString(1, taskName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTask(String oldName, Task updatedTask) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "UPDATE tasks SET task_name = ?, category = ?, deadline = ? WHERE task_name = ?")) {
            pstmt.setString(1, updatedTask.getName());
            pstmt.setString(2, updatedTask.getCategory());
            pstmt.setString(3, updatedTask.getDeadline());
            pstmt.setString(4, oldName);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Task> getTasks() {
        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM tasks")) {
            while (rs.next()) {
                taskList.add(new Task(
                        rs.getString("task_name"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getString("deadline")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskList;
    }
    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        int obs = observerList.indexOf(observer);
        observerList.remove(obs);
    }

    @Override
    public void notifyObservers(String string,String msg) {
        for (Observer observer : observerList) {
            observer.updateNotification(string, msg);
        }

    }

}
