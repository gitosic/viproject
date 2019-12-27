import com.vebinar.config.SpringConfig;
import com.vebinar.service.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//Этот класс нам уже не нужен. Я его не удаляю, а просто коментирую на веки вечные
public class App {
    /*//Таким образом мы, нажав на play запускам бин и он нам дает name из класса TestBean.
    public static void main(String[] args) {
        //SpringConfig.class - это он является конфигом для всех бинов
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean = context.getBean(TestBean.class);//Раз мы хотим использовать TestBean из SpringConfig тогда так это используем в стартере
        String name = bean.getName();//Получаем из класса TestBean имя

        System.out.println("Hello " + name + " !");
    }*/
}
