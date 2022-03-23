package 并发;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoin {

    private static long count = 0;

    private static void add10K(){
        int i = 0;
        while (i++<10000){
            count += 1;
        }
    }

    private static void add1(){

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(ForkJoin::add10K);
        Thread thread2 = new Thread(ForkJoin::add10K);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);

    }














    public static class CountTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 10000;
        private long start;
        private long end;

        public CountTask(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            long sum = 0;
            boolean canCompute = (end-start)<THRESHOLD;
            if(canCompute){
                for(long i = start;i<=end;i++){
                    sum += i;
                }
            }else {
                //分成100个小任务
                long step = (start+end)/100;
                ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
                long pos = start;
                for(int i = 0;i<100;i++){
                    long lastOne = pos + step;
                    if(lastOne>end){
                        lastOne = end;
                    }
                    CountTask subTask = new CountTask(pos,lastOne);
                    pos+=step+1;
                    subTasks.add(subTask);
                    subTask.fork();
                }
                for(CountTask t:subTasks){
                    sum += t.join();
                }
            }
            return sum;
        }

        public static void main(String[] args) {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            CountTask task = new CountTask(0,200000L);
            ForkJoinTask<Long> result = forkJoinPool.submit(task);
            try {
                long res = result.get();
                System.out.println("sum = "+res);
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
        }

    }
}
