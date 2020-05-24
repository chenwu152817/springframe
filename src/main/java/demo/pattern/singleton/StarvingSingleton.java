package demo.pattern.singleton;

/**
 * @author jjj
 * @date 2020/5/24 13:13
 */
public class StarvingSingleton {
    private static final StarvingSingleton starvingSingleton = new StarvingSingleton();
    private StarvingSingleton(){ }
    public static StarvingSingleton getInstance(){
        return starvingSingleton;
    }
}
