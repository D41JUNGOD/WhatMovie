import javax.swing.JButton;
import javax.swing.JFrame;

public class gui {
    JFrame frame = new JFrame("hi");
    JButton button = new JButton("z");

    public void createFrame(){
        frame.add(button);
        frame.setSize(300,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        gui frameExam = new gui();
        frameExam.createFrame();
    }
}
