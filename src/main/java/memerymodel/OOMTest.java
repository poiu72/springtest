package memerymodel;

import java.io.File;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/4/22.
 */
public class OOMTest
{
    public static void main(String[] args) {
        try {
            //准备url
            URL url = new File("/Users/feng/Desktop/个人资料-n/workspace/springtest/target/classes/memerymodel/").toURI().toURL();
            URL[] urls = {url};

            //获取有关类型加载的JMX接口
            ClassLoadingMXBean loadingBean = ManagementFactory.getClassLoadingMXBean();
            //用于缓存类加载器
            List<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
            while (true) {
                //加载类型并缓存类加载器实例
                ClassLoader classLoader = new URLClassLoader(urls);
                classLoaders.add(classLoader);
                classLoader.loadClass("memerymodel.Test");
                //显示数量信息（共加载过的类型数目，当前还有效的类型数目，已经被卸载的类型数目）
//                System.out.println("total: " + loadingBean.getTotalLoadedClassCount());
//                System.out.println("active: " + loadingBean.getLoadedClassCount());
//                System.out.println("unloaded: " + loadingBean.getUnloadedClassCount());
                System.out.println("classLoaders-----> " + classLoaders.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
