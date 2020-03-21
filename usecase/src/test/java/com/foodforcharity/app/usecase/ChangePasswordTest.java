package com.foodforcharity.app.usecase;

import com.foodforcharity.app.mediator.Mediator;
import com.foodforcharity.app.usecase.useraccount.changepassword.ChangePasswordCommand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChangePasswordTest {

    @Autowired
    Mediator mediator;

    public ChangePasswordTest() {
    }

    @Test
    public void testHandler() {
        ChangePasswordCommand command = new ChangePasswordCommand("AnnitaRosinski", "abcd", "password");
        mediator.publish(command);
    }

}