import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WorkerUtils {

    public  static  List<Worker> getWorkerList(){
        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker("Worker1",23,"Develop", LocalDate.of(2000,4,20),90000));
        workerList.add(new Worker("Worker2",31,"Develop", LocalDate.of(1989,4,21),80000));
        workerList.add(new Worker("AWorker3",25,"Testing", LocalDate.of(1994,5,24),28000));
        workerList.add(new Worker("AWorker4",33,"Admin", LocalDate.of(1992,3,23),42523));
        workerList.add(new Worker("aWorker5",43,"Hr", LocalDate.of(1997,1,16),70000));
        workerList.add(new Worker("Worker6",28,"Hr", LocalDate.of(1999,10,8),56000));
        workerList.add(new Worker("Worker6",30,"Hr", LocalDate.of(1998,10,8),59000));
        return workerList;
    }
}
