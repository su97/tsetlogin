package com.vita.licl.testlogin;

import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.*;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by pc on 2016/8/26.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    //测试规则
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testOfMain() throws InterruptedException {
        //点击顶部第一个按钮
        onView(withId(R.id.btn_a)).perform(click());
        //wait(2000);
        //检查新界面是否出现了登录按钮
        onView(withId(R.id.tv_login)).check(matches(withText("登录")));
        //wait(2000);
        //点击顶部第二个按钮
        onView(withId(R.id.btn_b)).perform(click());
       // wait(2000);
        //查看中心的图片是否显示
        onView(withId(R.id.imgview_3)).check(matches(isDisplayed()));
        //wait(2000);
        //点击顶部的第三个按钮，显示计算器界面
        onView(withId(R.id.btn_c)).perform(click());
        //wait(2000);
        //滑动到底部的加号按钮并点一下
        onView(withId(R.id.scrollFooter)).perform(scrollTo(),click());
        //wait(2000);
    }
}