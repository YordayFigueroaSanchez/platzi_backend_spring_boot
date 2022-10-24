package com.yfsanchez.fundamentos.bean;

import com.yfsanchez.fundamentos.FundamentosApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void print() {
        int numero = 1;
        try {
            int test = 10/0;
            LOGGER.info("valor obtenido " + test);
        } catch (Exception e){
            LOGGER.error("error en la operacion" + e.getStackTrace());
        }
        System.out.println("print desde bean MyBeanImpl.");
        System.out.println(this.myOperation.sum(numero));
    }
}
