import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.Timer;  
  
/**  
 * ����swing��Timer��ʹ��  
 * һ����ʾʱ���GUI����  
 * @author wasw100  
 *   
 */  
public class TimerTest extends JFrame implements ActionListener {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// һ����ʾʱ���JLabel  
    private JLabel jlTime = new JLabel();  
    private Timer timer;  
  
    public TimerTest() {  
        setTitle("Timer����");  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(180, 80);  
        add(jlTime);  
          
        //����Timer��ʱ����������  
        timer = new Timer(500, this);  
        timer.start();  
        setVisible(true);  
    }  
  
    /**  
     * ִ��TimerҪִ�еĲ��֣�  
     */  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        jlTime.setText(format.format(date));  
  
    }  
  
    public static void main(String[] args) {  
        new TimerTest();  
    }  
} 