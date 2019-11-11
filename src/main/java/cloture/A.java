package cloture;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * created by zhangzhiyuan in 2019/6/17
 */
public class A {
    private List<IListener> iListenerList;

    private void inject() {
        iListenerList = Lists.newArrayList();
        for (int j = 0; j < 100; j++) {
            B b = new B(j);
            IListener iListener = () -> b.say();
            iListenerList.add(iListener);
        }

    }

    private interface IListener {
        void getI();
    }

    public List<IListener> getiListenerList() {
        return iListenerList;
    }

    public static void main(String[] args) {
        A a = new A();
        a.inject();
        List<IListener> iListeners = a.getiListenerList();
        for (IListener iListener : iListeners) {
            iListener.getI();
        }
    }
}
