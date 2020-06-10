import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WorkerMain {
	public static void main(String[] args) {

		List<Worker> workers = WorkerUtils.getWorkerList();
		Predicate<Double> salCalculate = sal -> (sal < 60000);
		Predicate<Double> salCalc = sal -> (sal > 30000 && sal < 60000);
		Function<LocalDate, Integer> ageCalculation = dob -> (Period.between(dob, LocalDate.now()).getYears());

		// 1.List of Workers whose salary is less then 60000
		List<String> list = workers.stream().filter(w -> salCalculate.test(w.getSal())).map(w -> w.getName())
				.collect(Collectors.toList());

		list.forEach(worker -> System.out.println("List of less then 60000 salary Workers :" + worker));

		// 2.Count of workers whose salary greater than 30000 less than 60000
		Long count = workers.stream().filter(worker -> salCalc.test(worker.getSal())).count();
		System.out.println("Greater than 30000 less than 60000 Workers count : " + count);

		// 3.Oldest worker,get worker object and print
		Worker oldestWorker = workers.stream().min(Comparator.comparing(worker -> worker.getDob())).get();
		System.out.println("Oldest Worker :" + oldestWorker);

		// 4.Junior worker,get worker object and print
		Worker juniorWorker = workers.stream().max(Comparator.comparing(worker -> worker.getDob())).get();
		System.out.println("Junior Worker :" + juniorWorker);

		// 5.Highest paid worker,get worker object and print
		Worker highWorker = workers.stream().max(Comparator.comparing(worker -> worker.getSal())).get();
		System.out.println("Highest paid Worker :" + highWorker);

		// 6.lowest paid worker,get worker object and print
		Worker lowWorker = workers.stream().min(Comparator.comparing(worker -> worker.getSal())).get();
		System.out.println("Lowest paid Worker :" + lowWorker);

		// 7.Sort worker age, lowest to Highest,get list of worker names and print
		List<String> workerList = workers.stream().sorted((worker1, worker2) -> worker1.getAge() - worker2.getAge())
				.map(worker -> worker.getName()).collect(Collectors.toList());
		workerList.forEach(worker -> System.out.println("Sorted workers high to low by age :" + worker));

		// 8.Sort worker age , highest to lowest,get list of worker names and print
		List<String> listOfWorkers = workers.stream().sorted((worker1, worker2) -> worker2.getAge() - worker1.getAge())
				.map(w -> w.getName()).collect(Collectors.toList());
		listOfWorkers.forEach(worker -> System.out.println("Sorted workers low to high by age :" + worker));

		// 9.Average Salary of all workers
		// 10.Average age of all workers
		double avgAge = workers.stream().mapToInt(w -> ageCalculation.apply(w.getDob())).average().getAsDouble();

		System.out.println(avgAge);
		// 11.Group Using Department and print for each department
		Map<String, List<Worker>> employeeMap = workers.stream().collect(Collectors.groupingBy(Worker::getDept));
		employeeMap.forEach((String key, List<Worker> lisst) -> System.out.println("Dept Name :" + key + "" + lisst));

		// 12.count of worker age> 20 and salary <30000
		Long count1 = workers.stream().filter(w -> w.getAge() > 20 && w.getSal() < 30000).count();
		System.out.println("Worker Age more than 20 and salary less than 30000 :" + count1);

		// 13.Worker Count from each group
		Map<String, Long> map = workers.stream().collect(Collectors.groupingBy(Worker::getDept, Collectors.counting()));
		map.forEach((String key, Long value) -> System.out.println("Dept :" + key + ":Count : " + value));

		// 14.Total Salary of Each dept
		Map<String, Double> map1 = workers.stream()
				.collect(Collectors.groupingBy(Worker::getDept, Collectors.summingDouble(Worker::getSal)));
		map1.forEach((String key1, Double value1) -> System.out.println("Dept :" + key1 + ":Sum Salary : " + value1));

		// 15.Average salary of each dept
		Map<String, Double> map2 = workers.stream()
				.collect(Collectors.groupingBy(Worker::getDept, Collectors.averagingDouble(Worker::getSal)));
		map2.forEach((String key1, Double value1) -> System.out.println("Dept :" + key1 + ":Avg Salary : " + value1));

		// 16.Oldest employee of each dept
		Map<String, Double> map3 = workers.stream()
				.collect(Collectors.groupingBy(Worker::getDept, Collectors.averagingDouble(Worker::getSal)));
		map2.forEach((String key1, Double value1) -> System.out.println("Dept :" + key1 + ":Avg Salary : " + value1));

		// 17.Given the list of worker, find the worker with name “Some Name”.
		List<Worker> sdf=workers.stream().filter((m)->m.getName().equals("Worker1"))
				.collect(Collectors.toList());
		System.out.println("Names List : "+sdf);
		// 18.Join the all Worker names with “,” using java 8
		String s = workers.stream().map(worker -> worker.getName()).collect(Collectors.joining(",", "", ""));
		System.out.println("Worker Names with Camma ::" + s);

		// 19.remove the duplicate elements from the list
		Set<Worker> set = workers.stream()
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Worker::getName))));
		set.forEach(se -> System.out.println("Duplicate Object :" + se));

		// 20.List of employee whose name starts with "A"
		List<Worker> wor = workers.stream().filter(wo -> wo.getName().startsWith("A")).collect(Collectors.toList());
		wor.forEach(work -> System.out.println("Namestarts with A :" + work));
	}
}
