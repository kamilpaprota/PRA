package third.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static third.quartz.SQL.isCorrectquerry;


public class Program {

    public static void main(String[] args) throws InterruptedException, IOException {

        int  i = 1;
        File plik = new File("odp" + i + ".txt");

        while (plik.exists())
        {
            i++;
            plik = new File("odp" + i + ".txt");

        }
        plik.createNewFile();



        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();



            JobDetail job1 = newJob(Czas.class)
                    .withIdentity("myJob", "group1") // name "myJob", group "group1"
                    .usingJobData("jobSays", "Hello World!")
                    .build();

            Trigger trigger1 = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(cronSchedule("0 * * ? * MON-FRI"))
                    .build();


            scheduler.scheduleJob(job1, trigger1);
            scheduler.start();


            Scanner in = new Scanner(System.in);
            int nr;
            boolean first = true;
            String lista = "";
            System.out.print("Numer zadania: ");
            while((nr = in.nextInt()) != 0)
            {

                in.nextLine();

                System.out.print("Podaj treść zapytania SQL: ");
                String sql = in.nextLine();
                if (isCorrectquerry(sql))
                {
                    System.out.print("Dobre zapytanie\n");
                    if (first) {
                        lista = nr + "." + sql;
                    } else {
                        lista += "-" + nr + "." + sql;
                    }
                    first = false;
                }
                else
                {
                    System.out.print("Złe zapytanie\n");
                    boolean flag = false;
                    while (!flag)
                    {
                        System.out.print("Podaj treść zapytania SQL jeszcze raz: ");
                        sql = in.nextLine();
                        if (isCorrectquerry(sql))
                        {
                            if (first)
                            {
                                lista = nr + "." + sql;
                            }
                            else
                            {
                                lista += "-" + nr + "." + sql;
                            }
                            first = false;
                            System.out.print("Dobre zapytanie\n");
                            flag = true;

                        }
                    }
                }

                JobDetail job2 = newJob(SQL.class)

                        .usingJobData("lista", lista)
                        .usingJobData("path", plik.getPath())
                        .build();
                Trigger trigger2 = newTrigger()

                        .startNow()
                        .withSchedule(cronSchedule("0/30 * * ? * *"))
                        .build();

                scheduler.scheduleJob(job2, trigger2);
                scheduler.start();

                System.out.print("Podaj nr zadania: ");
            }


        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}

