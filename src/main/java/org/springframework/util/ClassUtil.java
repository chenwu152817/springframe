package org.springframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jjj
 * @date 2020/5/23 20:15
 */
@Slf4j
public class ClassUtil {
    public static final String FILE_PROTOCAOL = "file";

    /**
     * 获取包下类的集合
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName){
        //1.获取到类加载器
        ClassLoader classLoader = getClassLoader();
        //2.通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".","/"));
        if(url == null){
            log.warn("unable to retrieve anything from package:" + packageName);
            return null;
        }
        //3.根据不同的资源类型，采取不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        if(url.getProtocol().equalsIgnoreCase(FILE_PROTOCAOL)){
            classSet = new HashSet<Class<?>>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet,packageDirectory,packageName);
        }
        //过滤除文件类型的资源
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件
     * @param emptyClassSet
     * @param fileSource
     * @param packageName
     */
    private static void extractClassFile(final Set<Class<?>> emptyClassSet, final File fileSource, final String packageName) {
        if(!fileSource.isDirectory()){
            return;
        }
        //如果是一个文件夹，则调用其listFiles方法获取文件夹下的文件或文件夹
        File[] files = fileSource.listFiles(new FileFilter() {
            public boolean accept(File file) {
                if(file.isDirectory()){
                    return true;
                } else{
                    //获取文件的绝对值路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if(absoluteFilePath.endsWith(".class")){
                        //若是class文件，则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }
            //根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
            private void addToClassSet(String absoluteFilePath) {
                //1.从class文件的绝对值路径里提取出包含了package的类名
                absoluteFilePath = absoluteFilePath.replace(File.separator, ".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0, className.lastIndexOf("."));
                //2.通过反射机制获取对应的Class对象并加入到classSet里
                Class targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });
        if(files != null){
            for(File f : files){
                //递归调用
                extractClassFile(emptyClassSet, f, packageName);
            }
        }
    }

    public static Class<?> loadClass(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("load class error:",e);
            throw new RuntimeException(e);
        }
    }



    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        extractPackageClass("demo.pattern.factory.entity");
    }

}
