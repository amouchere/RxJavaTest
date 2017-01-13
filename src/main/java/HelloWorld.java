/**
 * Created by antoine on 13/01/17.
 */

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {

        Flowable.just("Hello world")
                .subscribe(System.out::println);

        Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);

        System.out.println("test");
        Thread.sleep(2000); // <--- wait for the flow to finish

    }
}
