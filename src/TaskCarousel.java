import java.util.ArrayList;

public class TaskCarousel {
    private final int capacity;
    private int curr = 0;
    private final ArrayList<Task> tasks = new ArrayList<>();

    public TaskCarousel(int capacity) { this.capacity = capacity; }

    public boolean addTask(Task task) {
        boolean flag = true;
        if (task.isFinished() || this.isFull()) flag = false;
        else if (task instanceof CountDownTask &&
                ((CountDownTask) task).getValue() == 0) {
            flag = false;
        } else this.tasks.add(task);
        return flag;
    }

    public boolean execute() {
        if (isEmpty()) return false;
        if (curr == tasks.size()) curr = 0;
        tasks.get(curr).execute();
        boolean flag = tasks.get(curr).getStatus();
        if (tasks.get(curr).isFinished()) tasks.remove(curr);
        else curr++;
        return flag;
    }

    public boolean isFull() { return tasks.size() == capacity; }

    public boolean isEmpty() { return tasks.isEmpty(); }

}
