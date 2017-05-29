import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.sql.Date;

/**
 * Created by Stanislav on 19.05.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException, DocumentException {
        Date date = new Date(117, 04, 19);
        System.out.println(date);
        Date date1 = new Date(117, 04, 22);
        System.out.println(date1);
        System.out.println("==========");
        System.out.println(date1.getTime());
        System.out.println(date.getTime());
        long result = date1.getTime() - date.getTime();
        System.out.println(result);
        System.out.println(result / 86400000);
        System.out.println("==========");
        /*User user = new User();
        user.setLogin("admin");
        user.setFullName("Vorozhka Stanislav");
        user.setPassport("MT0000001");
        Car car = new Car();
        car.setName("Diablo");
        car.setCost(10000000);
        car.setClazz(Class.SPORT);
        car.setMark(Mark.PORSCHE);
        TicketGenerator.createTicket("E:\\IdeaProjects\\SummaryTask4\\src\\main\\java\\", user, car);*/
    }
}
