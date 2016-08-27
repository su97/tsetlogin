package com.vita.licl.testlogin;
import android.content.Context;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by pc on 2016/8/26.
 */

@RunWith(MockitoJUnitRunner.class)
public class ListviewAdapterTest {

    //设成常量好判断
    private static final String FAKE_STR = "TITLE";

    @Mock//有这个关键字就是模拟的类
    SecondActivity secondActivity;//模拟的类
    Context mockContext;//也是模拟的

    @Test
    public void testAdapter(){
        //把数据初始化一下，
        List<Listitem> lst=new ArrayList<>();
        Listitem listitem=new Listitem();
        listitem.setTitle(FAKE_STR);
        lst.add(listitem);
        //secondActivity=new SecondActivity();
        //开始测试，ListviewAdapter是真正要测试的类，所以肯定得创建实例的
        SecondActivity.ListviewAdapter adapter = secondActivity.new ListviewAdapter(mockContext,lst);

        //检验结果
        assertThat(adapter.getItem(0).getTitle(),is(FAKE_STR));
    }

}