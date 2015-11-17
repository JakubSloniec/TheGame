package pl.edu.agh.two;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mateusz Pszczolka on 11/17/2015.
 */
public class Test {
    @Autowired
    Test2 test2;

    public Test2 getTest2() {
        return test2;
    }

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }
}
